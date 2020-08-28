class FactoryException extends Exception{
    
    public FactoryException(){
        super("FACTORY FAILED");
    }
    
    public FactoryException(String message){
        super(message);
    }
    
}
