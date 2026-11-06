package semester1.practice09.homework;

public class TransposeMatrixOperator extends AbstractMatrixOperator {
    public TransposeMatrixOperator() {
        super("Transpose(A^T)");
    }


    @Override
    public boolean isApplicable(EncapsulatedMatrix input) {
        return input != null;
    }

    @Override
    public EncapsulatedMatrix apply(EncapsulatedMatrix input) {
        double[][] result = new double[input.getCols()][input.getRows()];
        for (int i = 0; i < input.getRows(); i++) {
            for (int j = 0; j < input.getCols(); j++) {
                result[j][i] = input.getElement(i, j);
            }

        }

        return new EncapsulatedMatrix(result);
    }
}
