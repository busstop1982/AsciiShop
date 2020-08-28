import java.util.*;

public class AsciiShop{

	public static void main (String [] args){

        AsciiImage picture, copy;
        AsciiStack pile;
        MetricSet<AsciiImage> saved = new MetricSet<AsciiImage>();
        MetricSet<AsciiImage> pics;
        String todo = "";
        
        HashMap<String,Factory> Factories = new HashMap<String,Factory>();
        Factories.put("binary", new BinaryFactory() );
        Factories.put("clear", new ClearFactory() );
        Factories.put("filter", new FilterFactory() );
        Factories.put("load", new LoadFactory() );
        Factories.put("replace", new ReplaceFactory() );
        Factories.put("create", new CreateFactory() );
        Factories.put("save", new SaveFactory(saved) );
        Factories.put("search", new SearchFactory(saved) );

		Scanner nf = new Scanner(System.in);
        picture = new AsciiImage(5,5,"#&.");
        pile = new AsciiStack();

        while (nf.hasNext()){
            try{
                try{
                    todo = nf.next();
                    new debug(todo);
                    copy = new AsciiImage(picture);

                    if (Factories.containsKey(todo)){
                        new debug ("current pic \n"+copy.toString());
                        new debug ("in saved:");
                        new debug (saved);
                        new debug ("end saved");
                        picture = Factories.get(todo).create(nf).execute(copy);
                    }
                    else if ( todo.equals("print") ){
                        System.out.print(picture.toString());
                    }
                    else if ( todo.equals("printsaved") ){
                        pics = new SaveOperation(saved).getSaved();
                        if ( pics.size() == 0 ){
                            System.out.println("NO SAVED IMAGES");
                        }
                        else{
                            for (AsciiImage a: pics){
                                System.out.print(a.toString()+"\n");
                            }
                        }
                    }
                    else if ( todo.equals("undo") ){
                        if ( pile.size() == 0){
                            System.out.println("STACK EMPTY");
                        }else{
                            picture = pile.pop();
                        }
                    }
                    else if ( todo.equals("histogram") ){
                        AsciiImage histogram;
                        histogram = new Histogram().getHistogram(picture);
                        System.out.print(histogram.toString());
                    }
                    if (todo.equals("binary")||todo.equals("clear")||todo.equals("create")||todo.equals("filter")||todo.equals("load")||todo.equals("replace")){
                        pile.push(copy);
                    }
                }catch(FactoryException message){
                    System.out.println("catch INPUT MISSMATCH");
                    System.err.println(message);
                }
            }catch(OperationException message){
                System.out.println("catch OPERATION FAILED");
                System.err.println(message);
            }
        }
        nf.close();
	}
}
