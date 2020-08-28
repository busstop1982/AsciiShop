import java.util.Scanner;

class LoadFactory implements Factory{
    
    public LoadFactory(){
        
    }
    
    public Operation create(Scanner scanner) throws FactoryException{
        String eof = "", data = "", curr = "";

        if (scanner.hasNext()){
            eof=scanner.next();
        }else throw new FactoryException("no eof string");
        curr = scanner.next();
        while (!curr.equals(eof)){
            data+=curr+'\n';
            curr=scanner.next();
        }
        if(!curr.equals(eof)) throw new FactoryException("neverending story");
        return new LoadOperation(data);
    }
    
}
