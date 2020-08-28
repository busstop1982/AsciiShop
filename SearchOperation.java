import java.util.Iterator;

public class SearchOperation implements Operation{
    
    public MetricSet<AsciiImage> saved;
    public Metric<AsciiImage> m;
    
    public SearchOperation(MetricSet<AsciiImage> saved, Metric<AsciiImage> m){
        this.saved = saved;
        this.m = m;
    }
    
    public AsciiImage execute(AsciiImage img) throws OperationException{
        if (saved==null) throw new OperationException("no save file");
        MetricSet<AsciiImage> list = saved.search(img,m);
        Iterator<AsciiImage> itera = list.iterator();
        if (itera.hasNext()){
            return itera.next();
        }
        else throw new OperationException("no match found");
    }
}
