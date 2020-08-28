import java.util.*;

class MedianOperation extends FilterOperation{
    
    public AsciiImage execute(AsciiImage img){
        return super.execute(img);
    }
    
    public MedianOperation(BlockGenerator block){
        super(block);
    }
    
    public int filter(int [] values){
        Arrays.sort(values);
        return values[(values.length-1)/2];
    }
}
