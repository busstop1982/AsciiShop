class debug{

    public boolean bugging = false;

    
    public debug (String text){
        if (bugging) System.out.println(text);
    }
    
    public debug (char c){
        if (bugging) System.out.println(""+c);
    }
    
    public debug (int num){
        if (bugging) System.out.println(num);
    }
    
    public debug (float num){
        if (bugging) System.out.println(num);
    }
    
    public debug (AsciiImage img){
        if (bugging) System.out.print(img.toString());
    }
    
    public debug (MetricSet<AsciiImage> set){
        if (bugging){
            for (AsciiImage img:set){
                System.out.println(img.toString());
            }
        }
    }

}
