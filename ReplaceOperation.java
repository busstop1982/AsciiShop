import java.util.*;

class ReplaceOperation implements Operation{

    char oldChar;
    char newChar;
    ArrayList<AsciiPoint> oldPoints;
    
    public ReplaceOperation(char oldChar, char newChar){
        this.oldChar = oldChar;
        this.newChar = newChar;
    }
    
    public AsciiImage execute(AsciiImage img) throws OperationException{
        
        if ( img.getCharSet().indexOf(newChar) == -1 ){
            throw new OperationException("colors don't match");
        }
        oldPoints = img.getPointList(oldChar);
        for(AsciiPoint p: oldPoints){
            img.setPixel(p, newChar);
        }
        return img;
    }

}
