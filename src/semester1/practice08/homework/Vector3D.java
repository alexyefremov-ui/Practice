package semester1.practice08.homework;

public class Vector3D extends Vector2D{
    private double z;
    public Vector3D(double x, double y, double z){
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override public double getLength(){
        return Math.sqrt(Math.pow(super.getVectorX(), 2)+Math.pow(super.getVectorY(), 2)+Math.pow(z, 2));
    }

    public double dotProduct(Vector3D other){
        return super.dotProduct(other) + this.getZ() * other.getZ();
    }


    public Vector3D crossProduct(Vector3D other){
        return new Vector3D(
                super.getVectorY() * other.getZ() - this.getZ() * other.getVectorY(),
                this.getZ()*other.getVectorX() - super.getVectorX() * other.getZ(),
                super.getVectorX() * other.getVectorY() - super.getVectorY() * other.getVectorX()
        );
    }

    @Override public String toString(){
        return  String.format("Vector3D(%.2f; %.2f; %.2f) |L|=%.2f", this.getVectorX(), this.getVectorY(), getZ(), getLength());
    }
}
