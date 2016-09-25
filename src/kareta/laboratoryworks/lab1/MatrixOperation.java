package kareta.laboratoryworks.lab1;

import java.util.Arrays;
import java.util.Random;

public class MatrixOperation {

    public static final int MATRIX_DIMENSION = 8;
    public static final int MAX_MATRIX_ELEMENT = 9;

    public static void initialize(int[][] matrix) {
        Random generator = new Random();

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = new int[MATRIX_DIMENSION];
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = generator.nextInt(MAX_MATRIX_ELEMENT);
            }
        }
    }

    public static void print(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(Arrays.toString(matrix[row]));
        }
        System.out.println();
    }

    public static void convert(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int offset = 0; offset < matrix[row].length / 2; offset++) {
                int temporary = matrix[row][offset];
                matrix[row][offset] = matrix[row][matrix[row].length - offset - 1];
                matrix[row][matrix.length - offset - 1] = temporary;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[MATRIX_DIMENSION][];
        initialize(matrix);
        print(matrix);
        convert(matrix);
        print(matrix);
    }
}