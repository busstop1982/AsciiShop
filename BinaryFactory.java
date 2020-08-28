import java.util.Scanner;

class BinaryFactory implements Factory{
    
    public BinaryFactory(){
        
    }
    
    public Operation create(Scanner scanner) throws FactoryException{
        String s = "";
        char threshold = ' ';
        if (scanner.hasNext()){
            s=scanner.next();
            threshold = s.charAt(0);
        }
        else{
            throw new FactoryException("no valid string for threshold");
        }
        return new BinaryOperation(threshold);
    }
}
