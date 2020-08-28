//import java.util.*;

public class AsciiStack{

    private AsciiStackNode node;
    
	public AsciiStack(){
        node = null;
    }
    
    public boolean empty(){
        if (node.size() == 0) return true;
        else return false;
    }
    
    public void push (AsciiImage img){
        node = new AsciiStackNode(img,node);
    }
    
    public AsciiImage peek(){
        if (node.size()==0){
            return null;
        }
        else{
            debug("peeked:"+node.picture);
            return node.picture;
        }
    }
    
    public int size(){
        if ( node == null ) return 0;
        else return node.size();
    }
    
    public AsciiImage pop(){
        AsciiImage out = peek();
        debug("popped");
        debug(out.toString());
        if (node.size()!=0){
            node = node.next;
            }
        return out;
    }

    public static void debug(String message){
        boolean testing = false;
        if (testing){
            System.out.println(message);
        }
    }

    public class AsciiStackNode{
        
        private AsciiImage picture;
        private AsciiStackNode next;
        
        public AsciiStackNode(AsciiImage img, AsciiStackNode next){
            this.picture = img;
            this.next = next;
        }
        
        public int size(){
            if ( this.next == null ){
                return 1;
            }
            else return next.size()+1;
        }
    }

}
