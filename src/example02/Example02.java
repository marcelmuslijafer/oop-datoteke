package example02;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * This example shows the use of File constructors and methods
 */
public class Example02 {

    public static void main(String[] args) throws URISyntaxException, IOException {
        // Constructor #1 -  as an argument accepts a String representing a filename
        File f1 = new File("test-files/test.txt");
        //File f1Absolute = new File("/home/marcel/faculty/Tutoring/OOP/files/test-files/test.txt");

        // Constructor #2 - as arguments accepts a String representing the parent folder and a String representing
        //                  a file
        File f2 = new File("test-files", "test.txt");

        // Construcotr #3 - as arguments accepts a File representing the parent folder and a String representing a file
        File dir = new File("test-files");
        File f3 = new File(dir, "test.txt");

        // Constructor #4 - as an argument accepts a URI
        URI uri = new URI("file:/home/marcel/faculty/Tutoring/OOP/files/test-files/test.txt");
        File f4 = new File(uri);

        String absolutePath = f1.getAbsolutePath();
        File parent = f1.getParentFile();
        boolean exists = f1.exists();
        boolean readable = f1.canRead();
        boolean writeable = f1.canWrite();
        boolean executable = f1.canExecute();
        long fileSize = f1.length();
        boolean isFile = f1.isFile();
        boolean isDirectory = f1.isDirectory();
        boolean isHidden = f1.isHidden();

        System.out.println();

        System.out.println("Absolute path: " + absolutePath);
        System.out.println("Parent: " + parent);
        System.out.println("File exists: " + exists);
        System.out.println("File is readable: " + readable);
        System.out.println("File is writeable: " + writeable);
        System.out.println("File is executable: " + executable);
        System.out.println("File size: " + fileSize);
        System.out.println(f1.getName() + " is a file: " + isFile);
        System.out.println(f1.getName() + " is a directory: " + isDirectory);
        System.out.println(dir.getName() + " is a file: " + dir.isFile());
        System.out.println(dir.getName() + " is a directory: " + dir.isDirectory());
        System.out.println("Is it hidden: " + isHidden);

        System.out.println();
//
        File temporary = File.createTempFile("mojaprivremenadatoteka", "abc");
        System.out.println("Temporary file: " + temporary.getAbsolutePath());

        File toCreate = new File("test-files", "creating-using-java.txt");
        boolean newFile = toCreate.createNewFile();

        toCreate.delete();
    }
}
