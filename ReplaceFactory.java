import java.util.Scanner;

class ReplaceFactory implements Factory{
    
    public ReplaceFactory(){
        
    }
    
    public Operation create(Scanner scanner) throws FactoryException{
        char oldChar = ' ';
        char newChar = ' ';
        if (scanner.hasNext()){
            oldChar = scanner.next().charAt(0);
        }else throw new FactoryException("no oldChar");
        if (scanner.hasNext()){
            newChar = scanner.next().charAt(0);
        }else throw new FactoryException("no newChar");
        return new ReplaceOperation(oldChar,newChar);
    }
    
}
