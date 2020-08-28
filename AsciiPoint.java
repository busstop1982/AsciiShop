final public class AsciiPoint{

    int x, y;
    
	public AsciiPoint (int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public String toString(){
        String out = "("+getX()+","+getY()+")";
        return out;
    }
    
}
