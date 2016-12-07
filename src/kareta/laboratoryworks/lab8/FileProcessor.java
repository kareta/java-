package kareta.laboratoryworks.lab8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileProcessor implements Runnable {

    private String baseDirectory;
    private File file;

    public FileProcessor(String baseDirectory, File file) {
        this.baseDirectory = baseDirectory;
        this.file = file;
    }

    @Override
    public void run() {
        Path path = Paths.get(file.getPath());
        Path newFilePath = Paths.get(combine(baseDirectory, file.getName()));
        try {
            List<String> lines = Files.readAllLines(path);
            try (BufferedWriter writer = Files.newBufferedWriter(newFilePath)) {
                for (String line : lines) {
                    String reversedLine = new StringBuilder(line).reverse().toString();
                    writer.write(reversedLine);
                    writer.newLine();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static String combine(String path1, String path2)
    {
        File file1 = new File(path1);
        File file2 = new File(file1, path2);
        return file2.getPath();
    }
}
