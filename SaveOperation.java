import java.util.*;
class SaveOperation implements Operation{
    
    MetricSet<AsciiImage> saved;
    AsciiImage img;
    
    public SaveOperation(MetricSet<AsciiImage> saved){
        this.saved = saved;
    }
    
    public AsciiImage execute(AsciiImage img) throws OperationException{
        if ( !saved.contains(img) ){
            saved.add(img);
        }
        for (AsciiImage a: saved){
            new debug("saved:");
            new debug(a.toString());
        }
        return img;
    }
    
    public MetricSet<AsciiImage> getSaved(){
        return this.saved;
    }
}
