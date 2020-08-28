import java.util.*;

class CreateFactory implements Factory{
    
    public CreateFactory(){
        
    }
    
    public Operation create(Scanner scanner) throws FactoryException{
        String temp = scanner.nextLine();
        int height=0, width=0;
        Scanner buffer = new Scanner(temp);
        String charset = "";
        if ( buffer.hasNextInt() ){
            width = buffer.nextInt();
        } else throw new FactoryException("no width");
        if ( buffer.hasNextInt() ){
            height = buffer.nextInt();
        } else throw new FactoryException("no height");
        if ( buffer.hasNext() ){
            charset = buffer.next();
        }else throw new FactoryException("no charset");
        
        if ( height==0||width==0 ){
            throw new FactoryException("x and/or y are zero");
        }
        return new CreateOperation(width,height,charset);
    }
}
