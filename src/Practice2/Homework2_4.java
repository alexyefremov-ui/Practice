package Practice2;

public class Homework2_4 {
    public static void main(String[] args) {
        double a = 7.0;
        double b = 8.0;
        double c = 9.0;
        double p = a + b + c;
        double halfP = p/2.0;
        double s = Math.sqrt(halfP*(halfP-a)*(halfP-b)*(halfP-c));
        double radiusInscribedCircle = s/halfP;
        double areaInscribedCircle = Math.PI * Math.pow(radiusInscribedCircle, 2);
        double radiusCircumcircle = a*b*c/(4.0*s);
        double areaCircumcircle = Math.PI*Math.pow(radiusCircumcircle, 2);

        System.out.println("================ ГЕОМЕТРИЧНИЙ ЗВІТ ===============");
        System.out.println("Сторони: a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("Периметр (P):               " + p);
        System.out.println("Напівпериметр (p):          " + halfP);
        System.out.println("Площа трикутника (S):       " + s + " кв. од.");
        System.out.println("Радіус вписаного кола (r):  " + radiusInscribedCircle);
        System.out.println("Площа вписаного круга:      " + areaInscribedCircle + " кв. од.");
        System.out.println("Радіус описаного кола (R):  " + radiusCircumcircle);
        System.out.println("Площа описаного круга:      " + areaCircumcircle + " кв. од.");
        System.out.println("==================================================");




    }
}
