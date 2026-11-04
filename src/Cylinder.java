public class Cylinder extends Circle{
    private double height;


    public void setHeight(double height) {
        if (height <= 0) {
            System.out.println("Висота має буті більше 0, тому ми їй встановлюємо значення 1");
            height = 1;

        }
        this.height = height;
    }
    public Cylinder(double radius, double height){
        super(radius);
        this.setHeight(height);

    }
    public double getVolume(){
        return super.getArea()*height;
    }
    public double getTotalSurfaceArea(){
        return 2*super.getArea()+super.getCircumference()*height;
    }
    @Override public String toString(){
        return super.toString() + String.format("Cylinder h = %.2f, V = %.2f, TSA = %.2f", this.height, this.getVolume(), this.getTotalSurfaceArea());

    }
}
