import java.util.*;

class SaveFactory implements Factory{
    
    public MetricSet<AsciiImage> saved;
    
    public SaveFactory(MetricSet<AsciiImage> saved){
        this.saved = saved;
    }
    
    public Operation create(Scanner scanner) throws FactoryException{
        return new SaveOperation(saved);
    }
}
