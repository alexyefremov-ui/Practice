package semester1.semester1.practice10.homework;

import java.util.Arrays;

public final class PolynomialFunction extends AbstractMathFunction implements NewtonRootFindable {
    private final double[] coeffs;

    public PolynomialFunction(String formulaTitle, double[] coefficients) {
        super(formulaTitle);
        this.coeffs = Arrays.copyOf(coefficients, coefficients.length);
    }

    @Override
    public double evaluate(double x) {
        double result = 0;
        double power = 1;
        for (int i = 0; i < coeffs.length; i++) {
            result = result + coeffs[i] * power;
            power = power * x;
        }
        return result;
    }

    @Override
    public double derivative(double x) {
        double result = 0;
        double power = 1;
        for (int i = 1; i < coeffs.length; i++) {
            result = result + i * coeffs[i] * power;
            power = power * x;
        }
        return result;
    }
}
