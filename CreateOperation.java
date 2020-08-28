class CreateOperation implements Operation{
    
    int width, height;
    String charset;
    
    public CreateOperation(int width, int height, String charset){
        this.width=width;
        this.height=height;
        this.charset=charset;
    }
    
    public AsciiImage execute(AsciiImage img) throws OperationException{
        AsciiImage out = new AsciiImage(width,height,charset);
        return new ClearOperation().execute(out);
    }
}
