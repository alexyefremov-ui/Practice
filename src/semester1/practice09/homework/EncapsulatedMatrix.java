package semester1.practice09.homework;

public class EncapsulatedMatrix {
    private final int rows;
    private final int cols;
    private final double[][] grid;

    public EncapsulatedMatrix(double[][] source) {
        boolean valid = source != null && source.length > 0;
        if (valid) {
            valid = source[0] != null && source[0].length > 0;
        }


        if (valid) {
            for (int i = 0; i < source.length; i++) {
                if (source[i] == null || source[i].length != source[0].length) {
                    valid = false;
                }
            }
        }

        if (!valid) {
            rows = 1;
            cols = 1;
            grid = new double[1][1];
        } else {
            rows = source.length;
            cols = source[0].length;
            grid = new double[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = source[i][j];

                }
            }
        }
    }

    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }

    public double[][] getGridCopy() {
        double[][] copy = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        return copy;
    }

    public double getElement(int r, int c) {
        if (r < 0 || c < 0 || r >= rows || c >= cols) {
            System.out.println("Помилка: неправильні індекси елемента матриці!");
            return 0;
        }
        return grid[r][c];
    }

    public boolean isSquare() {
        return rows == cols;
    }
    public double getTrace() {
        if (!isSquare()) {
            System.out.println("Слід можна знайти тільки для квадратної матриці!");
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += grid[i][i];
        }
        return sum;
    }

    public double getFrobeniusNorm() {
        double sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += grid[i][j] * grid[i][j];
            }
        }
        return Math.sqrt(sum);

    }

    public double getDeterminant() {
        if (!isSquare()) {
            System.out.println("Визначник є тільки у квадратної матриці!");
            return 0;
        }
        if (rows == 1) {
            return grid[0][0];
        }
        if (rows == 2) {
            return grid[0][0] * grid[1][1] - grid[0][1] * grid[1][0];
        }
        if (rows == 3) {
            return grid[0][0] * grid[1][1] * grid[2][2]
                    + grid[0][1] * grid[1][2] * grid[2][0]
                    + grid[0][2] * grid[1][0] * grid[2][1]
                    - grid[0][2] * grid[1][1] * grid[2][0]
                    - grid[0][0] * grid[1][2] * grid[2][1]
                    - grid[0][1] * grid[1][0] * grid[2][2];
        }
        System.out.println("Визначник підтримується лише для матриць 2x2 і 3x3!");
        return 0;
    }

    @Override
    public String toString() {
        String result = String.format("Матриця (%dx%d | Норма Фробеніуса: %.2f",
                rows, cols, getFrobeniusNorm());
        if (isSquare()) {
            result += String.format(" | Слід: %.2f", getTrace());
            if (rows <= 3) {
                result += String.format(" | det: %.2f", getDeterminant());
            }
        }

        result += "):\n";
        for (int i = 0; i < rows; i++) {
            result += "  [ ";
            for (int j = 0; j < cols; j++) {
                result += String.format("%7.2f ", grid[i][j]);
            }
            result += "]\n";
        }

        return result;
    }
}
