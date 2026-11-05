package semester1.practice08.homework;

public class Vector2D {
    private double x;
    private double y;
    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;

    }
    public Vector2D(){
        this.x = 0.0;
        this.y = 0.0;

    }
    public double getVectorX(){
        return this.x;

    }
    public double getVectorY(){
        return this.y;

    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getLength(){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
    public double dotProduct(Vector2D other){
        return this.x*other.getVectorX()+this.y*other.getVectorY();
    }
    @Override public String toString(){
        return  String.format("Vector2D(%.2f; %.2f) |L|=%.2f", x, y, getLength());
    }
}
