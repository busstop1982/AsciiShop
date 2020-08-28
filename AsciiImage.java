import java.util.*;

public class AsciiImage{
    
    private int width, height;
    private char [][] picture;
    private String charset;
    
    public AsciiImage(int width, int height, String charset){
        this.height = height;
        this.width = width;
        this.charset = charset;
        picture = new char [width] [height];
        if ( width >= 0 && height >= 0 && charCheck(charset) ){
            for (int j=0;j<height;j++){
                for (int i=0;i<width;i++){
                    picture[i][j]=charset.charAt(charset.length()-1);
                }
            }
        }
        else{
            throw new IllegalArgumentException("width:"+width+"height:"+height+"charcheck:"+charCheck(charset));
        }
    }
    
    public AsciiImage(AsciiImage img){
        this.height = img.getHeight();
        this.width = img.getWidth();
        this.charset = img.getCharSet();
        picture = new char [width][height];
        for (int y=0;y<img.height;y++){
            for (int x=0;x<img.width;x++){
                //debug("x:"+x+"y:"+y);
                picture[x][y]=img.getPixel(x,y);
            }
        }
    }
    
    public boolean charCheck(String charset){
        new debug("charcheckset:"+charset);
        if ( charset.length() == 0 ){
            new debug("charsetlength=0");
            return false;
        }
        else{
            for (int i=0;i<charset.length();i++){
                for (int j=i+1;j<charset.length();j++){
                    if ( charset.charAt(i) == charset.charAt(j) ){
                        new debug(charset.charAt(i)+"");
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public int getWidth(){
        return this.width;
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public char getPixel(int x, int y){
        if ( x>=0&&y>=0&&x<this.width&&y<this.height ){
            return picture[x][y];
        }
        else throw new IndexOutOfBoundsException();
    }
    
    public char getPixel(AsciiPoint p){
        return getPixel(p.getX(),p.getY());
    }
    
    public String getCharSet(){
        return this.charset;
    }
    
    public void setPixel(int x, int y, char c){
        if ( x<0||y<0||x>=this.width||y>=this.height||charset.indexOf(c)==-1){
            new debug(charset);
            throw new IndexOutOfBoundsException("x:"+x+"y:"+y+"char:"+c);
        }
        else picture[x][y]=c;
    }
    
    public void setPixel(AsciiPoint p, char c){
        setPixel(p.getX(),p.getY(),c);
    }
    
    public String toString(){
        String out="";
        for (int y=0;y<getHeight();y++){
            for (int x=0;x<getWidth();x++){
                out+=getPixel(x,y);
            }
            out+="\n";
        }
        return out;
    }
    
    public boolean equals(Object o){
        if ( ((AsciiImage)o).getWidth() != getWidth() ){
            return false;
        }
        else if ( ((AsciiImage)o).getHeight() != getHeight() ){
            return false;
        }
        else{
            for (int m=0;m<getHeight();m++){
                for (int n=0;n<getWidth();n++){
                    if ( ((AsciiImage)o).getPixel(n,m) != picture[n][m] ){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public int getUniqueChars(){
        String out = "";
        for (int i=0;i<getHeight();i++){
            for (int j=0;j<getWidth();j++){
                if ( out.indexOf(picture[j][i]) == -1 ){
                    out+=picture[j][i];
                }
            }
        }
        return out.length();
    }
    
    public int hashCode(){
        String chars = "";
        int out = 0;
        for (int i=0;i<getHeight();i++){
            for (int j=0;j<getWidth();j++){
                if ( chars.indexOf(picture[j][i]) == -1 ){
                    chars+=picture[j][i];
                }
            }
        }
        for(int i=0;i<chars.length();i++){
            out+=Character.getNumericValue(chars.charAt(i));
        }
        return out;
    }
    
    public ArrayList<AsciiPoint> getPointList(char c){
        ArrayList<AsciiPoint> list = new ArrayList<AsciiPoint>();
        for (int y=0;y<getHeight();y++){
            for (int x=0;x<getWidth();x++){
                if (getPixel(x,y) == c ){
                    AsciiPoint d = new AsciiPoint(x,y);
                    //debug(d.toString());
                    list.add(d);
                }
            }
        }
        return list;
    }

}
