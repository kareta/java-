package kareta.laboratoryworks.lab8;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Type path to source and destination: ");
        String sourcePath  = console.next();
        String destinationPath  = console.next();
        new File(destinationPath).mkdir();
        File folder = new File(sourcePath);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && isJavaFile(listOfFiles[i].getName())) {
                FileProcessor fileProcessor = new FileProcessor(destinationPath, listOfFiles[i]);
                Thread thread = new Thread(fileProcessor);
                thread.run();
            }
        }
    }

    public static boolean isJavaFile(String fileName) {
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }
        return Objects.equals(extension, "java");
    }
}
