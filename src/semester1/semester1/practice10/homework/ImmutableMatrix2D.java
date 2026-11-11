package semester1.semester1.practice10.homework;

import java.util.Arrays;

public final class ImmutableMatrix2D {
    private final int rows;
    private final int cols;
    private final double[][] data;

    public ImmutableMatrix2D(double[][] source) {
        this.rows = source.length;
        this.cols = source[0].length;
        this.data = new double[rows][];
        for (int i = 0; i < rows; i++) {
            data[i] = Arrays.copyOf(source[i], cols);
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double get(int r, int c) {
        return data[r][c];
    }

    public double[][] getDataCopy() {
        double[][] copy = new double[rows][];
        for (int i = 0; i < rows; i++) {
            copy[i] = Arrays.copyOf(data[i], cols);
        }
        return copy;
    }

    public double getTrace() {
        double sum = 0;
        for (int i = 0; i < rows && i < cols; i++) {
            sum = sum + data[i][i];
        }
        return sum;
    }

    public double getFrobeniusNorm() {
        double sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum = sum + data[i][j] * data[i][j];
            }
        }
        return Math.sqrt(sum);
    }

    public double getDeterminant() {
        if (rows == 2 && cols == 2) {
            return data[0][0] * data[1][1] - data[0][1] * data[1][0];
        }
        if (rows == 3 && cols == 3) {
            return data[0][0] * data[1][1] * data[2][2]
                    + data[0][1] * data[1][2] * data[2][0]
                    + data[0][2] * data[1][0] * data[2][1]
                    - data[0][2] * data[1][1] * data[2][0]
                    - data[0][1] * data[1][0] * data[2][2]
                    - data[0][0] * data[1][2] * data[2][1];
        }
        return Double.NaN;
    }

    public double maxAbsDifference(ImmutableMatrix2D other) {
        if (other == null || rows != other.rows || cols != other.cols) {
            return Double.NaN;
        }
        double result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result = Math.max(result, Math.abs(data[i][j] - other.get(i, j)));
            }
        }
        return result;
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            String line = "  [";
            for (int j = 0; j < cols; j++) {
                line = line + String.format(" %8.4f", data[i][j]);
            }
            System.out.println(line + " ]");
        }
    }
}
