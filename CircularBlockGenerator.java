class CircularBlockGenerator extends BlockGenerator{
    
    public CircularBlockGenerator(int edge){
        super(edge);
    }

    public int getPixel(AsciiImage img, int x, int y){
        int i=x,j=y;

        if (i<0){
            new debug("<loop"+i);
            i+=img.getWidth();
        }
        new debug("between"+i);
        if (i>=img.getWidth()){
            new debug(">loop"+img.getWidth());
            i-=img.getWidth();
        }
        if (j<0){
            j+=img.getHeight();
        }
        if (j>=img.getHeight()){
            j-=img.getHeight();
        }
new debug("(x/y):("+i+"/"+j+")"+img.getWidth());
        return img.getCharSet().indexOf(img.getPixel(i,j));
    }
}
