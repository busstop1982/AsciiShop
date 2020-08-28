import java.lang.*;
import java.util.*;

abstract class FilterOperation implements Operation{
    
    BlockGenerator block;
    
    public FilterOperation(BlockGenerator block){
        this.block = block;
    }
    
    public AsciiImage execute(AsciiImage img){
        AsciiImage out = new AsciiImage(img);
        for (int x=0;x<img.getWidth();x++){
            for (int y=0;y<img.getHeight();y++){
                int [] values = block.getBlock(img,x,y);
                int med = filter(values);
                out.setPixel(x,y,img.getCharSet().charAt(med));
            }
        }
        return out;
    }
    
    public abstract int filter (int[] values);
    
}
