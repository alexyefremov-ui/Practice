package semester1.semester1.practice10.homework;

public class TransposeOperator extends AbstractMatrixOperator implements OrthogonalOperator {
    public TransposeOperator() {
        super("Transpose(A^T)");
    }

    @Override
    public boolean canApply(ImmutableMatrix2D m) {
        return m != null;
    }

    @Override
    protected ImmutableMatrix2D transform(ImmutableMatrix2D m) {
        double[][] values = new double[m.getCols()][m.getRows()];
        for (int i = 0; i < m.getRows(); i++) {
            for (int j = 0; j < m.getCols(); j++) {
                values[j][i] = m.get(i, j);
            }
        }
        return new ImmutableMatrix2D(values);
    }

    @Override
    public ImmutableMatrix2D applyInverse(ImmutableMatrix2D transformed) {
        return transform(transformed);
    }
}
