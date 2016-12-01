package kareta.laboratoryworks.lab7;

public class MatrixTransposer {
    public void transpose(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        int[][] transposedMatrix = new int[matrix[0].length][];
        for (int[] row : transposedMatrix) {
            row = new int[matrix.length];
        }

        for (int i = 0; i < transposedMatrix.length; i++) {
            for (int j = 0; j < transposedMatrix.length; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
    }
}
