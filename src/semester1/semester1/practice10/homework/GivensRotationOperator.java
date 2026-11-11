package semester1.semester1.practice10.homework;

public class GivensRotationOperator extends AbstractMatrixOperator implements OrthogonalOperator {
    private final double angleRadians;

    public GivensRotationOperator(double angleDegrees) {
        super(String.format("GivensRotation(%.1f°)", angleDegrees));
        angleRadians = angleDegrees * Math.PI / 180.0;
    }

    @Override
    public boolean canApply(ImmutableMatrix2D m) {
        return m != null && m.getRows() >= 2;
    }

    @Override
    protected ImmutableMatrix2D transform(ImmutableMatrix2D m) {
        return rotateRows(m, angleRadians);
    }

    @Override
    public ImmutableMatrix2D applyInverse(ImmutableMatrix2D transformed) {
        return rotateRows(transformed, -angleRadians);
    }

    private ImmutableMatrix2D rotateRows(ImmutableMatrix2D m, double angle) {
        double[][] values = m.getDataCopy();
        double c = Math.cos(angle);
        double s = Math.sin(angle);
        for (int j = 0; j < m.getCols(); j++) {
            values[0][j] = c * m.get(0, j) - s * m.get(1, j);
            values[1][j] = s * m.get(0, j) + c * m.get(1, j);
        }
        return new ImmutableMatrix2D(values);
    }
}
