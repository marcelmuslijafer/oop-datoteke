package example03;

import java.io.File;
import java.nio.file.Path;

/**
 * This example shows some methods of the Path class
 */
public class Example03 {

    public static void main(String[] args) {
        Path path = Path.of("test-files/test.txt");

        System.out.println("File name: " + path.getFileName());
        System.out.println("Absolute path: " + path.toAbsolutePath());
        System.out.println(path.getFileName() + " is an excel file: " + path.toString().endsWith(".xlsx"));
        System.out.println(path.getFileName() + " is a text file: " + path.toString().endsWith(".txt"));
        System.out.println(path.getFileName() + " is in directory \"test-files\": " + path.startsWith("test-files"));

        File f = path.toFile();
        f.toPath();
    }
}
