package semester1.practice09.homework;

public class PolynomialFunction extends AbstractFunction1D {
    private final double[] coeffs;

    public PolynomialFunction(String expressionName, double[] coefficients) {
        super(expressionName);

        if (coefficients == null || coefficients.length == 0) {
            coeffs = new double[1];

        } else {
            coeffs = new double[coefficients.length];

            for (int i = 0; i < coefficients.length; i++) {
                coeffs[i] = coefficients[i];
            }
        }
    }

    public double[] getCoefficients() {

        double[] copy = new double[coeffs.length];

        for (int i = 0; i < coeffs.length; i++) {
            copy[i] = coeffs[i];
        }
        return copy;
    }

    @Override
    public double evaluate(double x) {
        double result = 0;

        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
    }

    @Override
    public double analyticDerivative(double x) {
        double result = 0;

        for (int i = 1; i < coeffs.length; i++) {
            result += i * coeffs[i] * Math.pow(x, i - 1);
        }

        return result;
    }

    @Override
    public String toString() {
        String result = getExpressionName() + " = ";
        for (int i = 0; i < coeffs.length; i++) {
            if (i > 0) {
                result += " + ";
            }
            result += String.format("%.2f", coeffs[i]);
            if (i == 1) {
                result += "*x";
            } else if (i > 1) {
                result += "*x^" + i;
            }
        }

        return result;
    }
}
