package semester1.practice09.homework;

public class DiagonalShiftOperator extends AbstractMatrixOperator {
    private final double lambda;

    public DiagonalShiftOperator(double lambda) {
        super("DiagonalShift(+" + lambda + "*I)");
        this.lambda = lambda;
    }

    @Override
    public boolean isApplicable(EncapsulatedMatrix input) {
        return input != null && input.isSquare();
    }

    @Override
    public EncapsulatedMatrix apply(EncapsulatedMatrix input) {
        double[][] result = input.getGridCopy();
        for (int i = 0; i < input.getRows(); i++) {
            result[i][i] += lambda;
        }
        return new EncapsulatedMatrix(result);

    }
}
