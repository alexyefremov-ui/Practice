package semester1.semester1.practice10.homework;

public class NonZeroScaleOperator extends AbstractMatrixOperator implements InvertibleOperator {
    private final double factor;

    public NonZeroScaleOperator(double factor) {
        super(String.format("Scale(x%.1f)", factor));
        this.factor = factor;
    }

    @Override
    public boolean canApply(ImmutableMatrix2D m) {
        return m != null && factor != 0;
    }

    @Override
    protected ImmutableMatrix2D transform(ImmutableMatrix2D m) {
        double[][] values = m.getDataCopy();
        for (int i = 0; i < m.getRows(); i++) {
            for (int j = 0; j < m.getCols(); j++) {
                values[i][j] = values[i][j] * factor;
            }
        }
        return new ImmutableMatrix2D(values);
    }

    @Override
    public ImmutableMatrix2D applyInverse(ImmutableMatrix2D transformed) {
        double[][] values = transformed.getDataCopy();
        for (int i = 0; i < transformed.getRows(); i++) {
            for (int j = 0; j < transformed.getCols(); j++) {
                values[i][j] = values[i][j] / factor;
            }
        }
        return new ImmutableMatrix2D(values);
    }
}
