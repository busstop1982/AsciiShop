class ReplicateBlockGenerator extends BlockGenerator{

    public ReplicateBlockGenerator(int edge){
        super(edge);
    }
 
    public int getPixel(AsciiImage img, int x, int y){
        if (x<0){
            x=0;
        }
        if (x>=img.getWidth()){
            x=img.getWidth()-1;
        }
        if (y<0){
            y=0;
        }
        if (y>=img.getHeight()){
            y=img.getHeight()-1;
        }
        return img.getCharSet().indexOf(img.getPixel(x,y));
    }
}
