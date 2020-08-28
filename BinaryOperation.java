class BinaryOperation implements Operation{
    
    char threshold;
    AsciiImage img;
    
    public BinaryOperation(char threshold){
        this.threshold=threshold;
    }
    
    public AsciiImage execute(AsciiImage img) throws OperationException{
        char light = img.getCharSet().charAt(img.getCharSet().length()-1);
        char dark = img.getCharSet().charAt(0);
        this.img = img;
        if ( img.getCharSet().indexOf(threshold) == -1 ) throw new OperationException("char not in charString");
        for (int x=0;x<img.getWidth();x++){
            for (int y=0;y<img.getHeight();y++){
                if (smaller(img.getPixel(x,y))){
                    img.setPixel(x,y,dark);
                }
                else img.setPixel(x,y,light);
            }
        }
        return img;
    }
    
    public boolean smaller(char c){
        int border = img.getCharSet().indexOf(this.threshold);
        int current = img.getCharSet().indexOf(c);
        if (current < border) return true;
        else return false;
    }
    
}
