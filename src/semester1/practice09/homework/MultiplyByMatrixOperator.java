package semester1.practice09.homework;

public class MultiplyByMatrixOperator extends AbstractMatrixOperator {
    private final EncapsulatedMatrix rightMatrix;

    public MultiplyByMatrixOperator(EncapsulatedMatrix rightMatrix) {
        super("Multiply(A*B)");
        this.rightMatrix = rightMatrix;
    }

    @Override
    public boolean isApplicable(EncapsulatedMatrix input) {
        return input != null && rightMatrix != null && input.getCols() == rightMatrix.getRows();
    }

    @Override
    public EncapsulatedMatrix apply(EncapsulatedMatrix input) {
        double[][] result = new double[input.getRows()][rightMatrix.getCols()];

        for (int i = 0; i < input.getRows(); i++) {

            for (int j = 0; j < rightMatrix.getCols(); j++) {

                for (int k = 0; k < input.getCols(); k++) {
                    result[i][j] += input.getElement(i, k) * rightMatrix.getElement(k, j);

                }
            }
        }
        return new EncapsulatedMatrix(result);
    }
}
