package semester1.semester1.practice10.homework;

public class UpperTriangularProjection extends AbstractMatrixOperator {
    public UpperTriangularProjection() {
        super("UpperTriangularProjection");
    }

    @Override
    public boolean canApply(ImmutableMatrix2D m) {
        return m != null;
    }

    @Override
    protected ImmutableMatrix2D transform(ImmutableMatrix2D m) {
        double[][] values = m.getDataCopy();
        for (int i = 0; i < m.getRows(); i++) {
            for (int j = 0; j < m.getCols(); j++) {
                if (i > j) {
                    values[i][j] = 0;
                }
            }
        }
        return new ImmutableMatrix2D(values);
    }
}
