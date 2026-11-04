public class Task1GeometryInheritance {
    public static void main(String[] args) {
        System.out.println("================ ГЕОМЕТРІЯ ТІЛ ОБЕРТАННЯ ================");
        System.out.println("Базове коло:");
        Circle circle = new Circle(5);
        System.out.println(circle);

        System.out.println();

        System.out.println("Циліндр (успадковано від Circle):");
        Cylinder cylinder = new Cylinder(5, 10);
        System.out.println(cylinder);

        System.out.println();
        System.out.println("Конус (успадковано від Circle):");
        Cone cone = new Cone(3, 4);
        System.out.println(cone);
    }


}
