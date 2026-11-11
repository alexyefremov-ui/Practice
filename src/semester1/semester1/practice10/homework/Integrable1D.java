package semester1.semester1.practice10.homework;

public interface Integrable1D extends Evaluable1D {
    default double integrateSimpson(double a, double b, int n) {
        if (n < 2) {
            n = 100;
        }
        if (n % 2 != 0) {
            n++;
        }

        double h = (b - a) / n;
        double sum = evaluate(a) + evaluate(b);
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 2 == 0) {
                sum = sum + 2 * evaluate(x);
            } else {
                sum = sum + 4 * evaluate(x);
            }
        }
        return sum * h / 3;
    }
}
