package semester1.practice08.homework;

public class Circle {

    private double radius;
    public Circle(double rad){
        this.setRadius(rad);
    }
    public void setRadius(double radius){
        if (radius<=0){
            System.out.println("Радіуc має буті більше 0, тому ми йому встановлюємо значення 1");
            radius = 1;

        }
        this.radius = radius;

    }

    public double getRadius(){
        return this.radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public double getCircumference(){
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString(){
        return String.format("semester1.practice08.homework.Circle[r=%.2f, S=%.2f, C=%.2f]", radius, getArea(), getCircumference());

    }
}

