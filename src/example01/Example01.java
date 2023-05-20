package example01;

import java.io.File;
import java.util.Arrays;

/**
 * This example shows how to get platform specific information about the file system.
 */
public class Example01 {

    public static void main(String[] args) {
        // File.separator = character used as a separator in file paths : String
        System.out.println(File.separator);

        // File.separator = character used as a separator in file paths : char
        System.out.println(File.separatorChar);

        // File.pathSeparator = character used as a separator between two file paths : String
        System.out.println(File.pathSeparator);

        // File.pathSeparator = character used as a separator between two file paths : char
        System.out.println(File.pathSeparatorChar);

        // File.listRoots() = list the available file system roots : File[]
        System.out.println(Arrays.toString(File.listRoots()));
    }
}
