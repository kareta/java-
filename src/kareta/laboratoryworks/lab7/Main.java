package kareta.laboratoryworks.lab7;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    handleExceptions();

///home/vitya/matrix /home/vitya/matrixcopy
    }

    public static void handleExceptions() {
        Scanner in = null;
        BufferedWriter out = null;

        try {
            Scanner console = new Scanner(System.in);
            System.out.println("Type path to source and destination file: ");
            String sourcePath  = console.next();
            String destinationPath  = console.next();

            in = new Scanner(new FileInputStream(sourcePath));
            out = new BufferedWriter(new FileWriter(destinationPath));
            run(in, out);
        } catch (FileNotFoundException e) {
            System.out.println("Incorrect path");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void run(Scanner in, BufferedWriter out) throws IOException {

        int rowsAmount = in.nextInt();
        int columnsAmount = in.nextInt();

        MatrixTransposer transposer = new MatrixTransposer();
        int[][] matrix = transposer.getEmptyMatrix(rowsAmount, columnsAmount);

        for (int i = 0; i < rowsAmount; i++) {
            for (int j = 0; j < columnsAmount; j++) {
                if (in.hasNextInt()) {
                    matrix[i][j] = in.nextInt();
                }
            }
        }

        transposer.print(matrix);
        matrix = transposer.transpose(matrix);
        System.out.println();
        transposer.print(matrix);

        out.write(rowsAmount + " " + columnsAmount + "\n");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                out.write(matrix[i][j] + " ");
            }
            out.newLine();
        }
    }
}
