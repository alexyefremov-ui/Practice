package semester1.semester1.practice10.homework;

public interface Differentiable1D extends Evaluable1D {
    double derivative(double x);

    default double numericalDerivative(double x) {
        double h = 0.00001;
        return (evaluate(x + h) - evaluate(x - h)) / (2 * h);
    }
}
