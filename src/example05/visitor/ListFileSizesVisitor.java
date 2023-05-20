package example05.visitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class ListFileSizesVisitor extends SimpleFileVisitor<Path> {

    private int depth = 0;

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("--".repeat(depth) + dir.getFileName());
        depth++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("--".repeat(depth) + file.getFileName() + " " +  attrs.lastModifiedTime());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        if (depth == 1)
            System.out.println();
        depth--;
        return FileVisitResult.CONTINUE;
    }
}
