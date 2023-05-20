package example05.visitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CountFilesAndDirectoriesVisitor extends SimpleFileVisitor<Path> {
    private int numberOfFiles = 0;
    private int numberOfDirectories = 0;

    public int getNumberOfFiles() {
        return numberOfFiles;
    }

    public int getNumberOfDirectories() {
        return numberOfDirectories;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        numberOfFiles++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        numberOfDirectories++;
        return FileVisitResult.CONTINUE;
    }
}
