package example08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Example08 {

    public static void main(String[] args) throws IOException {
        // InputStreamReader isr = new InputStreamReader(Files.newInputStream(Path.of("test-files/duplicates.txt")), StandardCharsets.US_ASCII);
        BufferedReader br = Files.newBufferedReader(Path.of("duplicates.txt"));
        String line = null;
        while ((line = br.readLine()) != null) {

        }
    }
}
