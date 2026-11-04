public class Cone extends Circle{
    private double height;

    public void setHeight(double height) {
        if (height <= 0) {
            System.out.println("Висота має буті більше 0, тому ми їй встановлюємо значення 1");
            height = 1;

        }
        this.height = height;
    }
    public Cone(double radius, double height){
        super(radius);
        this.setHeight(height);

    }

    public double getSlantHeight(){
        return Math.sqrt(getRadius() * getRadius() + height * height);

    }

    public double getVolume(){
        return 1/3.0 * super.getArea()*height;
    }
    public double getTotalSurfaceArea(){
        return super.getArea()+Math.PI*super.getRadius()*getSlantHeight();
    }

    @Override public String toString(){
        return super.toString() + String.format("Cylinder h = %.2f, V = %.2f, TSA = %.2f", this.height, this.getVolume(), this.getTotalSurfaceArea());
    }

}
