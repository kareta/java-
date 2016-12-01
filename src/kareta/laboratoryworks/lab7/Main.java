package kareta.laboratoryworks.lab7;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Type path to source and destination file: ");
        String sourcePath  = console.next();
        String destinationPath  = console.next();

        Scanner in = null;
        BufferedWriter out = null;

        try {
            in = new Scanner(new FileInputStream(sourcePath));
            out = new BufferedWriter(new FileWriter(destinationPath));

            while (in.hasNextInt()) {
                int number = in.nextInt();
                System.out.println(number);
            }
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
}
