package semester1.practice09.homework;

public abstract class AbstractMatrixOperator {
    private final String operatorName;

    public AbstractMatrixOperator(String operatorName) {
        this.operatorName = operatorName;
    }
    public String getOperatorName() {
        return operatorName;
    }
    public abstract boolean isApplicable(EncapsulatedMatrix input);
    public abstract EncapsulatedMatrix apply(EncapsulatedMatrix input);
    public final EncapsulatedMatrix executeSafely(EncapsulatedMatrix input) {

        if (input != null && isApplicable(input)) {
            return apply(input);
        }
        System.out.println("Попередження: оператор '" + operatorName + "' не підходить до матриці!");
        return input;
    }
}
