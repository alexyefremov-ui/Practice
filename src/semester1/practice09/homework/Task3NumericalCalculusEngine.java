package semester1.practice09.homework;

public class Task3NumericalCalculusEngine {
    public static void main(String[] args) {
        System.out.println("================ ЛАБОРАТОРІЯ ЧИСЕЛЬНОГО АНАЛІЗУ ================");

        double[] coefficients = {1, 0, 1};
        PolynomialFunction g = new PolynomialFunction("g(x)", coefficients);
        coefficients[0] = 100;
        double[] copy = g.getCoefficients();
        copy[2] = 100;

        System.out.println("1. Многочлен " + g);
        System.out.printf("   Значення g(2.0) = %.2f\n", g.evaluate(2));
        System.out.printf("   Аналітична похідна g'(2.0) = %.6f | Чисельна = %.6f (Похибка: %.2e)\n", g.analyticDerivative(2), g.numericalDerivative(2), g.getDerivativeError(2));
        System.out.printf("   Інтеграл на [0.00; 3.00] (N=1000): %.4f (Точне значення: 12.0)\n", g.integrateTrapezoidal(0, 3, 1000));
        System.out.println("   Захисне копіювання: g(2.0) залишається " + g.evaluate(2));

        SineWaveFunction f = new SineWaveFunction("f(x)", 2, 1, 0);
        System.out.println("\n2. Гармонічна функція " + f);
        System.out.printf("   Інтеграл на [0.00; %.4f] (N=1000): %.4f\n", Math.PI, f.integrateTrapezoidal(0, Math.PI, 1000));

        CompositeFunction1D h = new CompositeFunction1D(f, g);
        double x = 1.5;

        System.out.println("\n3. Суперпозиція H(x) = f(g(x)) = 2*sin(x^2 + 1):");
        System.out.println("   Назва композиції: " + h.getExpressionName());
        System.out.printf("   -> H(%.2f) = %.6f\n", x, h.evaluate(x));
        System.out.printf("   -> Аналітична похідна H'(%.2f): %.6f\n", x, h.analyticDerivative(x));
        System.out.printf("   -> Чисельна похідна H'(%.2f): %.6f\n", x, h.numericalDerivative(x));
        System.out.printf("   -> Розбіжність між формулами: %.2e\n", h.getDerivativeError(x));
        if (h.getDerivativeError(x) < 0.000000001) {
            System.out.println("   -> Похибка менша за 10^-9: так");
        }
        System.out.println("================================================================");
    }
}
