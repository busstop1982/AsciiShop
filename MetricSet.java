import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Collection;

class MetricSet<E> extends LinkedHashSet<E>{
    
    public MetricSet(){
        
    }
    
    public MetricSet(Collection<? extends E> c){
        this.addAll(c);
    }
    //E=AsciiImage, e = img, m=metric
    public MetricSet<E> search(E e, Metric<? super E> m){
        Iterator<E> itor = this.iterator();
        E img = itor.next();
        MetricSet<E> out = new MetricSet<E>();
        int dist = m.distance(e,img);
        out.add(img);
        while (itor.hasNext()){
            new debug("distance:"+dist);
            img = itor.next();
            if (m.distance(e,img)<dist){
                out.clear();
                out.add(img);
            }
            else if (m.distance(e,img)==dist){
                out.add(img);
            }
            }
        return out;
    }
}
