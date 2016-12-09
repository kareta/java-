package kareta.laboratoryworks.lab8;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Type path to source and destination: ");
        String sourcePath  = console.next();
        String destinationPath  = console.next();
        new File(destinationPath).mkdir();

        File sourceFolder = new File(sourcePath);
        File destFolder = new File(destinationPath);

        if (!sourceFolder.exists()) {
            System.out.println("Source folder does not exist");
            return;
        }
        if (!destFolder.exists()) {
            System.out.println("Destination folder does not exist");
            return;
        }

        try {
            copyDirectory(sourceFolder, destFolder);
        } catch (IOException e) {
            System.out.println("Error while processing files");
        }
    }

    public static void copy(File sourceLocation, File targetLocation) throws IOException {
        if (sourceLocation.isDirectory()) {
            copyDirectory(sourceLocation, targetLocation);
        } else if (sourceLocation.isFile() && isJavaFile(sourceLocation.getName())) {
            FileProcessor fileProcessor = new FileProcessor(sourceLocation, targetLocation);
            System.out.println(sourceLocation.getPath());
            Thread thread = new Thread(fileProcessor);
            thread.start();
        }
    }

    private static void copyDirectory(File source, File target) throws IOException {
        if (!target.exists()) {
            target.mkdir();
        }

        for (String file : source.list()) {
            copy(new File(source, file), new File(target, file));
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
