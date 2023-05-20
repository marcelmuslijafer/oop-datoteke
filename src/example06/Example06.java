package example06;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * This example shows how input and output streams are used.
 */
public class Example06 {

    public static void main(String[] args) {
        Path img = Paths.get("test-files/jelly.jpg");
        // Print bytes in hexadecimal to the standard output
        try (InputStream is = Files.newInputStream(img, StandardOpenOption.READ)) {
            byte[] buff = new byte[1024];
            while (true) {
                int numberOfBytesRead = is.read(buff);
                if (numberOfBytesRead <= 0)
                    break;

                for (int i = 0; i < numberOfBytesRead; i++) {
                    System.out.format("%02x ", buff[i]);
                    if (i % 4 == 0) {
                        System.out.print("\t");
                    }
                    if (i % 8 == 0) {
                        System.out.println();
                    }
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // Write bytes into another file
        try (InputStream is = Files.newInputStream(img);
             OutputStream os = Files.newOutputStream(Path.of("test-files/jelly-copy.jpg"), StandardOpenOption.CREATE)
        ) {
            byte[] buff = new byte[1024];
            while (true) {
                int r = is.read(buff);
                if (r <= 0)
                    break;
                os.write(buff);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
