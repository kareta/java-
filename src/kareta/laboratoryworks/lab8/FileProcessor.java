package kareta.laboratoryworks.lab8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileProcessor implements Runnable {

    private File sourceFile;
    private File destFile;

    public FileProcessor(File sourceFile, File destFile) {
        this.sourceFile = sourceFile;
        this.destFile = destFile;
    }

    @Override
    public void run() {
        Path path = Paths.get(sourceFile.getPath());
        Path newFilePath = Paths.get(destFile.getPath());
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
}
