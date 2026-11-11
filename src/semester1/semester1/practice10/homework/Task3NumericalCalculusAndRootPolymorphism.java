package semester1.semester1.practice10.homework;

public class Task3NumericalCalculusAndRootPolymorphism {
    public static void main(String[] args) {
        AbstractMathFunction[] functions = {
                new PolynomialFunction("P(x) = x^3 - 2x - 5", new double[]{-5, -2, 0, 1}),
                new DampedHarmonyFunction(4, 0.5, 2),
                new StepHeavisideFunction(1.5, 2, 5)
        };

        System.out.println("========== ЧИСЕЛЬНИЙ АНАЛІЗ ТА ПОЛІМОРФІЗМ ==========");
        for (int i = 0; i < functions.length; i++) {
            AbstractMathFunction fn = functions[i];
            int steps = 100;
            if (fn instanceof StepHeavisideFunction) {
                steps = 1000;
            }
            System.out.println("\n" + (i + 1) + ". " + fn.getFormulaTitle());
            System.out.println(String.format("  Інтеграл Сімпсона на [0; 3], N=%d: %.6f",
                    steps, fn.integrateSimpson(0, 3, steps)));

            if (fn instanceof NewtonRootFindable rootFunction) {
                double x = 2.0;
                double initial = 2.0;
                if (fn instanceof DampedHarmonyFunction) {
                    x = 1.0;
                    initial = 0.7;
                }
                System.out.println(String.format("  Похідна в x=%.1f: точна %.6f, чисельна %.6f",
                        x, rootFunction.derivative(x), rootFunction.numericalDerivative(x)));
                double root = rootFunction.findRootNewton(initial, 50);
                System.out.println(String.format("  Корінь методом Ньютона: x=%.7f; f(x)=%.3e",
                        root, fn.evaluate(root)));
            } else {
                System.out.println("  Функція має розрив, тому похідна і метод Ньютона не застосовуються.");
            }
        }
        System.out.println("\nДля сходинки точне значення інтеграла = 10.500000;");
        System.out.println("формула Сімпсона дає невелику похибку біля точки розриву.");
    }
}
