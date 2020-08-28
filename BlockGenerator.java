abstract class BlockGenerator{
    
    private int size;
    
    public BlockGenerator(int size){
        this.size = size;
    }
    
    public int [] getBlock(AsciiImage img, int x, int y){
        int stop = (size-1)/2;
        int[] out = new int[size*size];
        int k=0;
        for (int i=-stop;i<=stop;i++){
            for (int j=-stop;j<=stop;j++){
                out[k]=getPixel(img,x+i,y+j);
                k++;
            }
        }

        return out;
    }
    
    public abstract int getPixel(AsciiImage img, int x, int y);

}
