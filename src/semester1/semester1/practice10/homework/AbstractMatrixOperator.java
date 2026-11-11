package semester1.semester1.practice10.homework;

public abstract class AbstractMatrixOperator {
    private final String operatorName;

    public AbstractMatrixOperator(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public abstract boolean canApply(ImmutableMatrix2D m);

    protected abstract ImmutableMatrix2D transform(ImmutableMatrix2D m);

    public final ImmutableMatrix2D execute(ImmutableMatrix2D m) {
        if (m == null || !canApply(m)) {
            System.out.println("  Оператор '" + operatorName + "' не можна застосувати.");
            return null;
        }
        ImmutableMatrix2D result = transform(m);
        if (this instanceof OrthogonalOperator ort) {
            System.out.println("  Перевірка збереження норми: " +
                    (ort.verifyNormInvariance(m, result) ? "успішна" : "помилка"));
        }
        return result;
    }
}
