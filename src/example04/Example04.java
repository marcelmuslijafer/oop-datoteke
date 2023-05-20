package example04;

import example04.filters.FilterByExtensions;
import example04.filters.FilterBySize;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This example shows how DirectoryStream<T> and DirectoryStream.Filter<T> are used.
 */
public class Example04 {

    public static void main(String[] args) throws IOException {
        // Create a path object for the test-files directory
        Path dir = Path.of("test-files");

        // For iterating through directory files
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir);
        for (Path p : directoryStream) {
            System.out.println(p);
        }

        System.out.println();

        DirectoryStream<Path> filteredBySize = Files.newDirectoryStream(dir, new FilterBySize(10000));
        DirectoryStream<Path> filteredByExtensions = Files.newDirectoryStream(dir, new FilterByExtensions("txt", "csv"));

        System.out.println();
        System.out.println("Filtered by size: ");
        for (Path p : filteredBySize) {
            System.out.println(p + " " + p.toFile().length());
        }

        System.out.println();
        System.out.println("Filtered by extensions: ");
        for (Path p: filteredByExtensions) {
            System.out.println(p);
        }


        directoryStream.close();
        filteredBySize.close();
        filteredByExtensions.close();
    }
}
