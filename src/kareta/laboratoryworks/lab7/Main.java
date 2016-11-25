package kareta.laboratoryworks.lab7;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Type path to source and destination file: ");
        String sourcePath  = console.next();
        String destinationPath  = console.next();

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(sourcePath);
            out = new FileOutputStream(destinationPath);

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Incorrect path");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
