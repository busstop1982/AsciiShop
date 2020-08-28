class PixelCountMetric implements Metric<AsciiImage>{
    
    public int distance(AsciiImage i1, AsciiImage i2){
        return Math.abs(i1.getHeight()*i1.getWidth()-i2.getHeight()*i2.getWidth());
    }
}
