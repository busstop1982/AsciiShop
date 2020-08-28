import java.util.*;

class AverageOperation extends FilterOperation{

    public AsciiImage execute(AsciiImage img){
        return super.execute(img);
    }
    
    public AverageOperation(BlockGenerator block){
        super(block);
    }
     
    public int filter(int[] values){
        float sum = 0;
        for (int color: values){
            sum+=color;
        }
        sum/= (float) values.length;
        new debug("avg-fil"+Math.round(sum));
        return (int) Math.round(sum);
    }
}
