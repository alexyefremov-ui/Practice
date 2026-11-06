package semester1.practice08.homework;

public class ForceVector3D extends Vector3D {
    private String forceName;

    public ForceVector3D(String forceName, double fx, double fy, double fz) {
        super(fx, fy, fz);
        this.forceName = forceName;
    }

    public double calculateWork(Vector3D displacement) {
        return super.dotProduct(displacement);
    }

    public double calculateAcceleration(double massKg) {
        if (massKg <= 0) {
            return 0.0;
        } else {
            return getLength() / massKg;
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s |F|=%.2f Н", forceName, super.toString(), getLength());
    }
}
