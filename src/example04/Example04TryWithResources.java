package example04;

import example04.filters.FilterByExtensions;
import example04.filters.FilterBySize;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Example04TryWithResources {
    public static void main(String[] args) {
        // Create a path object for the test-files directory
        Path dir = Path.of("test-files");

        // For iterating through directory files
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir)) {
            for (Path p : directoryStream) {
                System.out.println(p);
            }
        } catch (IOException ioe) {
            System.out.println("Error when creating a directory stream for: " + dir.getFileName());
        }

        System.out.println();


        try(DirectoryStream<Path> filteredBySize = Files.newDirectoryStream(dir, new FilterBySize(100));
            DirectoryStream<Path> filteredByExtensions = Files.newDirectoryStream(dir, new FilterByExtensions("txt", "csv"));)
        {
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
        } catch (IOException ioe) {
            System.out.println("Error when creating filtered directory streams");
        }
    }
}
