package semester1.semester1.practice10.homework;

public interface NewtonRootFindable extends Differentiable1D {
    default double findRootNewton(double x0, int maxIter) {
        double x = x0;
        for (int i = 0; i < maxIter; i++) {
            if (Math.abs(evaluate(x)) <= EPSILON) {
                break;
            }
            double d = derivative(x);
            if (Math.abs(d) < 1e-12) {
                break;
            }
            x = x - evaluate(x) / d;
        }
        return x;
    }
}
