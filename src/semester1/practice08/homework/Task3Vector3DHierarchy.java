package semester1.practice08.homework;

public class Task3Vector3DHierarchy {
    public static void main(String[] args) {
        System.out.println("================ ІЄРАРХІЯ ВЕКТОРІВ (2D -> 3D -> FORCE) ================");

        Vector2D vector2D = new Vector2D(3, 4);
        System.out.println("1. Рівень 1 (2D): " + vector2D);

        Vector3D vector3D = new Vector3D(3, 4, 12);
        System.out.println("2. Рівень 2 (3D): " + vector3D);

        Vector3D displacement = new Vector3D(2, 0, 5);


        System.out.println("   Вектор переміщення S: " + displacement);
        ForceVector3D force = new ForceVector3D("Тяга ракети", 3, 4, 12);

        System.out.println("\n3. Рівень 3 (Фізична сила):");
        System.out.println("   " + force);
        double work = force.calculateWork(displacement);
        System.out.printf("   -> Виконана механічна робота A = F · S = %.2f Дж%n", work);

        double massKg = 2.5;
        double acceleration = force.calculateAcceleration(massKg);
        System.out.printf("   -> Прискорення тіла масою %.1f кг: a = %.2f м/с²%n", massKg, acceleration);

        System.out.println("=======================================================================");
    }
}
