package semester1.practice08.homework;

public class Task3Vector3DHierarchy {
    public static void main(String[] args) {
        Vector2D v = new Vector2D(2, 5);
        Vector2D other = new Vector2D(2, 5);
        v.dotProduct(other);
        Vector3D v2 = new Vector3D(2, 5, 7);
        Vector3D other3 = new Vector3D(2, 5, 6);
        v2.dotProduct(other3);
    }
}
