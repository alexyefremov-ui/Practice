package semester1.practice09.homework;

public abstract class AbstractFunction1D {
    private final String expressionName;

    public AbstractFunction1D(String expressionName) {
        this.expressionName = expressionName;
    }

    public String getExpressionName() {
        return expressionName;
    }
    public abstract double evaluate(double x);
    public abstract double analyticDerivative(double x);

    public final double numericalDerivative(double x) {
        double h = 0.00001;
        return (evaluate(x + h) - evaluate(x - h)) / (2 * h);
    }


    public final double getDerivativeError(double x) {
        return Math.abs(analyticDerivative(x) - numericalDerivative(x));
    }

    public final double integrateTrapezoidal(double a, double b, int intervals) {
        if (intervals <= 0) {
            intervals = 1000;
        }

        double step = (b - a) / intervals;
        double sum = (evaluate(a) + evaluate(b)) / 2;
        for (int i = 1; i < intervals; i++) {
            sum += evaluate(a + i * step);
        }

        return step * sum;
    }

    @Override public String toString() {
        return expressionName;
    }
}
