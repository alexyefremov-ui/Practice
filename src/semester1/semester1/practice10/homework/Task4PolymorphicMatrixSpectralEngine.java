package semester1.semester1.practice10.homework;

public class Task4PolymorphicMatrixSpectralEngine {
    public static void main(String[] args) {
        ImmutableMatrix2D original = new ImmutableMatrix2D(new double[][]{
                {3, 4},
                {0, 5}
        });
        AbstractMatrixOperator[] operators = {
                new NonZeroScaleOperator(2),
                new TransposeOperator(),
                new GivensRotationOperator(60)
        };

        System.out.println("========== СПЕКТРАЛЬНИЙ КОНВЕЄР МАТРИЦЬ ==========");
        System.out.println(String.format("Початкова матриця (норма %.4f, слід %.2f, det %.2f):",
                original.getFrobeniusNorm(), original.getTrace(), original.getDeterminant()));
        original.printMatrix();

        System.out.println("\nПрямий хід:");
        ImmutableMatrix2D current = original;
        for (int i = 0; i < operators.length; i++) {
            current = operators[i].execute(current);
            System.out.println(String.format("  %d. %s -> норма %.4f, det %.2f",
                    i + 1, operators[i].getOperatorName(), current.getFrobeniusNorm(), current.getDeterminant()));
        }
        System.out.println("Матриця після перетворень:");
        current.printMatrix();

        System.out.println("\nЗворотний хід:");
        for (int i = operators.length - 1; i >= 0; i--) {
            AbstractMatrixOperator op = operators[i];
            if (op instanceof InvertibleOperator inv) {
                current = inv.applyInverse(current);
                System.out.println("  Скасовано оператор " + op.getOperatorName());
            }
        }
        System.out.println("Відновлена матриця:");
        current.printMatrix();
        double error = original.maxAbsDifference(current);
        System.out.println(String.format("Максимальна похибка: %.2e", error));
        System.out.println("Точність відновлення < 1e-9: " + (error < 1e-9));

        System.out.println("\nПриклад незворотного оператора:");
        AbstractMatrixOperator projection = new UpperTriangularProjection();
        System.out.println("  " + projection.getOperatorName() + " -> " +
                (projection instanceof InvertibleOperator ? "оборотний" : "необоротний"));
    }
}
