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

        try {
            Scanner console = new Scanner(System.in);
            System.out.println("Type path to source and destination file: ");
            String sourcePath  = console.next();
            String destinationPath  = console.next();

            File sourceFile = new File(sourcePath);
            File destFile = new File(destinationPath);
            run(sourceFile, destFile);
        } catch (FileNotFoundException e) {
            System.out.println("Incorrect path");
        } catch (IOException e) {
            System.out.printf("IO error happened");
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public static void run(File in, File out) throws IOException {
        MatrixIO matrixIO = new MatrixIO();
        MatrixTransposer transposer = new MatrixTransposer();

        int[][] matrix = matrixIO.getMatrix(in);

        transposer.print(matrix);
        matrix = transposer.transpose(matrix);
        System.out.println();
        transposer.print(matrix);
        matrixIO.putMatrix(matrix, out);
    }
}
