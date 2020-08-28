public class XBlockGenerator extends BlockGenerator{
    
    public XBlockGenerator(int edge){
        super(edge);
    }
    
    public int getPixel(AsciiImage img, int x, int y){
        int out;
        if (x<0||y<0||x>=img.getWidth()||y>=img.getHeight()){
            out = img.getCharSet().length()-1;
        }else out = img.getCharSet().indexOf(img.getPixel(x,y));
        return out;
    }
}
