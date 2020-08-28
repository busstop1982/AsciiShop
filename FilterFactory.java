import java.util.Scanner;

class FilterFactory implements Factory{
    
    public FilterFactory(){
        
    }
    
    public FilterOperation create(Scanner scanner) throws FactoryException{
        String tmp = scanner.nextLine();
        Scanner text = new Scanner(tmp);
        String task = text.next();
        String type="x";
        int borderlength = 3;
        
        for (int i=0;i<2;i++){
            if (text.hasNextInt()){
                borderlength = text.nextInt();
                if (borderlength==1||borderlength%2==0){
                    throw new FactoryException("invalid borderlength");
                }
            }
            else if (text.hasNext()){
                type = text.next();
                if (!type.equals("circular")&&!type.equals("replicate")&&!type.equals("symmetric")&&!type.equals("x")){
                throw new FactoryException("INPUT MISMATCH - no border");
                }
            }
            else break;
        }
        new debug("filtering:"+task+"-"+type+"-"+borderlength);

        if ( task.equals("median") ){
            return new MedianOperation(blocky(type,borderlength));
        }
        else if ( task.equals("average") ){
            return new AverageOperation(blocky(type,borderlength));
        }
        else throw new FactoryException("INPUT MISMATCH - no filter");
    }
    
    public BlockGenerator blocky(String type, int border){
        if (type.equals("circular")){
            return new CircularBlockGenerator(border);
        }
        if (type.equals("replicate")){
            return new ReplicateBlockGenerator(border);
        }
        if (type.equals("symmetric")){
            return new SymmetricBlockGenerator(border);
        }
        if (type.equals("x")){
            return new XBlockGenerator(border);
        }
        return null;
    }

}
