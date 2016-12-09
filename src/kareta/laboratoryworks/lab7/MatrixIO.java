package kareta.laboratoryworks.lab7;


import java.io.*;
import java.util.Scanner;

public class MatrixIO {
    public int[][] getMatrix(File file) {
        int[][] matrix;
        Scanner in = null;
        try {
            in = new Scanner(new FileInputStream(file));
            int rowsAmount = in.nextInt();
            int columnsAmount = in.nextInt();
            if (rowsAmount != columnsAmount) {
                System.out.println("Incorrect matrix dimensions");
                return null;
            }

            MatrixTransposer transposer = new MatrixTransposer();
            matrix = transposer.getEmptyMatrix(rowsAmount, columnsAmount);

            int count = 0;
            for (int i = 0; i < rowsAmount; i++) {
                for (int j = 0; j < columnsAmount; j++) {
                    if (in.hasNextInt()) {
                        matrix[i][j] = in.nextInt();
                        count++;
                    }
                }
            }

            if (count != rowsAmount * columnsAmount) {
                System.out.println("Incorrect matrix dimensions");
                return null;
            }

            return matrix;
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found");
        } finally {
            in.close();
        }

        return null;
    }

    public void putMatrix(int[][] matrix, File file) {
        if (matrix == null) {
            return;
        }

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(file));
            out.write(matrix.length + " " + matrix[0].length + "\n");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    out.write(matrix[i][j] + " ");
                }
                out.newLine();
            }
        } catch (IOException e) {
            System.out.println("Errors while outputing matrix");
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.printf("IO error happened");
                }
            }
        }
    }
}
