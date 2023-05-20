package example05;

import example05.visitor.CountFilesAndDirectoriesVisitor;
import example05.visitor.SearchForAFileVisitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * This example shows how to use FileVisitor and Files.walkFileTree
 */
public class Example05 {
    public static void main(String[] args) throws IOException {
        // Zadatak 1 : list all files in a directory and print the time when they were last modified, make the output readble
        // Zadatak 2 : count the number of files and directories
        // Zadatak 3 : search for a specific file in a directory

        Path start = Path.of("");


        CountFilesAndDirectoriesVisitor fv = new CountFilesAndDirectoriesVisitor();

        Files.walkFileTree(start, fv);

        System.out.println(fv.getNumberOfFiles());
        System.out.println(fv.getNumberOfDirectories());

        FileVisitor<Path> searchForAFile = new SearchForAFileVisitor("test.txt");
        Files.walkFileTree(start, searchForAFile);


    }
}
