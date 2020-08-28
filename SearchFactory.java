import java.util.*;

class SearchFactory implements Factory{
    
    MetricSet<AsciiImage> saved;
    
    public SearchFactory(MetricSet<AsciiImage> saved){
        this.saved = saved;
    }
    
    public Operation create(Scanner scanner) throws FactoryException{
        String task = scanner.next();
        if (task.equals("pixelcount")){
            return new SearchOperation(saved, new PixelCountMetric());
        }
        else if (task.equals("uniquechars")){
            return new SearchOperation(saved, new UniqueCharsMetric());
        }
        else throw new FactoryException("no valid metric");
    }
}
