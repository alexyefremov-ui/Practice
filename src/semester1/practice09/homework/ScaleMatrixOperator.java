package semester1.practice09.homework;

public class ScaleMatrixOperator extends AbstractMatrixOperator {
    private final double scaleFactor;
    public ScaleMatrixOperator(double scaleFactor) {

        super("Scale(x" + scaleFactor + ")");
        this.scaleFactor = scaleFactor;
    }

    @Override
    public boolean isApplicable(EncapsulatedMatrix input) {
        return input != null;
    }

    @Override
    public EncapsulatedMatrix apply(EncapsulatedMatrix input) {
        double[][] result = new double[input.getRows()][input.getCols()];
        for (int i = 0; i < input.getRows(); i++) {

            for (int j = 0; j < input.getCols(); j++) {
                result[i][j] = input.getElement(i, j) * scaleFactor;
            }

        }

        return new EncapsulatedMatrix(result);
    }
}
