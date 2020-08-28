public class LoadOperation implements Operation{
    
    AsciiImage picture;
    String data;
    
    public LoadOperation(String data){
        this.data = data;
    }
    
    public AsciiImage execute(AsciiImage img) throws OperationException{
        String [] lines = data.split("\n");
        int high = lines.length;
        int wide = lines[0].length();
        if ( high != img.getHeight() ){
            throw new OperationException("line numbers don't match - high1:"+lines.length+" high2:"+img.getHeight());
        }
        if ( wide != img.getWidth() ){
            throw new OperationException("line length doesn't match");
        }
        for (int i=1;i<high;i++){
            if (wide != lines[i].length()) throw new OperationException("lines unequal");
        }
        for (int j=0;j<high;j++){
            for (int i=0;i<wide;i++){
                if ( img.getCharSet().indexOf(lines[j].charAt(i)) == -1 ){
                    throw new OperationException("char not in scheme");
                }
                else img.setPixel(i,j,lines[j].charAt(i));
            }
        }
        return img;
    }
    
}
