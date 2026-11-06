package semester1.practice09.homework;

public class Task4MatrixOperatorPipeline {
    public static void main(String[] args) {
        System.out.println("================ КОНВЕЄР МАТРИЧНИХ ОПЕРАТОРІВ ================");

        double[][] numbers = {{1, 2}, {3, 4}};
        EncapsulatedMatrix matrix = new EncapsulatedMatrix(numbers);
        numbers[0][0] = 100;
        double[][] copy = matrix.getGridCopy();
        copy[0][1] = 100;

        System.out.println("Захисне копіювання: A[0][0] = " + matrix.getElement(0, 0) + ", A[0][1] = " + matrix.getElement(0, 1));

        MatrixPipeline pipeline = new MatrixPipeline("Чотири перетворення", 4);
        pipeline.addStage(new ScaleMatrixOperator(2));
        pipeline.addStage(new TransposeMatrixOperator());
        pipeline.addStage(new DiagonalShiftOperator(3));
        EncapsulatedMatrix right = new EncapsulatedMatrix(new double[][]{{1, 1}, {0, 1}});
        pipeline.addStage(new MultiplyByMatrixOperator(right));

        EncapsulatedMatrix result = pipeline.runPipeline(matrix);
        System.out.println("Початкова матриця не змінилася: A[0][0] = " + matrix.getElement(0, 0));
        System.out.println("Визначник кінцевої матриці: " + result.getDeterminant());
        System.out.println("================================================================");
    }
}
