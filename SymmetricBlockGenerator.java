public class SymmetricBlockGenerator extends BlockGenerator{
    
    public SymmetricBlockGenerator(int edge){
        super(edge);
    }
    
    public int getPixel(AsciiImage img, int x, int y){
        if (x<0){
            x=Math.abs(x)-1;
        }
        if (x>=img.getWidth()){
            x-=2*(x-img.getWidth())+1;
        }
        if (y<0){
            y=Math.abs(y)-1;
        }
        if (y>=img.getHeight()){
            y-=2*(y-img.getHeight())+1;
        }
        return img.getCharSet().indexOf(img.getPixel(x,y));
    }
}
