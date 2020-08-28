import java.util.*;

class Histogram{
    

    public static AsciiImage getHistogram(AsciiImage img){
        int height = 16, width = img.getCharSet().length()+3, most=0;
        String charString = "0123456789";
        int [] centages = new int[img.getCharSet().length()];
        
        if ( img.getCharSet().indexOf('#') == -1 ){
            charString+='#';
        }
        charString+=img.getCharSet();
        if ( charString.indexOf('.') == -1 ){
            charString+='.';
        }
        
        debug("chars:"+img.getCharSet());
        debug(charString);
        
        AsciiImage histogram = new AsciiImage(width,height,charString);
        histogram = new ClearOperation().execute(histogram);
        for (int i=0;i<img.getCharSet().length();i++){
            histogram.setPixel(i+3,15,img.getCharSet().charAt(i));
            debug(img.getCharSet().charAt(i)+"");
        }

        debug(histogram.toString());
        
        for (int i = 0;i<img.getCharSet().length();i++){
            centages[i]=percent(img.getCharSet().charAt(i),img);
            if ( centages[i]>most ) most=centages[i];
        }
        
        debug("most:"+most);
        
        for (int i=0;i<15;i+=2){
            int value = most*(100-100*i/16)/100;
            debug("value:"+value);
            if ( value == 100 ) {
                histogram.setPixel(0,i,'1');
                histogram.setPixel(1,i,'0');
                histogram.setPixel(2,i,'0');
            }
            else{
                if (value/10 != 0){
                    histogram.setPixel(1,i,intToChar(value/10));
                }
                histogram.setPixel(2,i,intToChar(value%10));
            }
        }
        
        debug(histogram.toString());

        for (int j=3;j<width;j++){
            for (int i=0;i<15;i++){
                if (most*(100-100*i/16)/100<=centages[j-3]){
                    histogram.setPixel(j,i,'#');
                }
            }
        }
        return histogram;
    }
    
    public static int percent(char color, AsciiImage img){
        int area = img.getHeight()*img.getWidth();
        int abs;
        ArrayList<AsciiPoint> cuco = new ArrayList<AsciiPoint>();
        cuco = img.getPointList(color);
        abs = cuco.size();
        float out = 100*((float) abs / (float) area);
        return Math.round(out);
    }
    
    public static char intToChar(int number){
        char out = (char) (number+48);
        return out;
    }
    
    public static void debug(String message){
        boolean testing = false;
        if (testing){
            System.out.println(message);
        }
    }
}
