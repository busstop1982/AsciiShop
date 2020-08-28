public class ClearOperation implements Operation{
    
    AsciiImage img;
    
    public ClearOperation(){

    }

    public AsciiImage execute(AsciiImage img){
        img = new AsciiImage(img);
        String charset = img.getCharSet();
        for (int j=0;j<img.getHeight();j++){
            for (int i=0;i<img.getWidth();i++){
                img.setPixel(i,j,charset.charAt(charset.length()-1));
            }
        }
        return img;
    }
}
