package kareta.laboratoryworks.lab7;

public class MatrixTransposer {

    public int[][] getEmptyMatrix(int rowsAmount, int columnsAmount) {
        int[][] matrix = new int[rowsAmount][];

        for (int i = 0; i < rowsAmount; i++) {
            matrix[i] = new int[columnsAmount];
        }

        return matrix;
    }

    public int[][] transpose(int[][] matrix) {
        if (matrix == null) {
            return matrix;
        }

        int[][] transposedMatrix = new int[matrix[0].length][];
        for (int i = 0; i < matrix[0].length; i++) {
            transposedMatrix[i] = new int[matrix.length];
        }

        for (int i = 0; i < transposedMatrix.length; i++) {
            for (int j = 0; j < transposedMatrix[0].length; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }

        return transposedMatrix;
    }

    public void print(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
