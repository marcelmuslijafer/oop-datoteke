package example05.visitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class SearchForAFileVisitor extends SimpleFileVisitor<Path> {
    private String filename;

    public SearchForAFileVisitor(String filename) {
        this.filename = filename;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        if (path.getFileName().toString().equals(filename)) {
            System.out.println("FOUND!!!");
            System.out.println("File is regular: " + attrs.isRegularFile());
            System.out.println("Last modified time: " + attrs.lastModifiedTime());
            System.out.println("File size: " + attrs.size());
            System.out.println("File creation time: " + attrs.creationTime());
            return FileVisitResult.TERMINATE;
        }

        return FileVisitResult.CONTINUE;
    }
}
