package example07;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * This example shows the usage of charsets
 */
public class Example07 {
    public static void main(String[] args) {
        Charset c = StandardCharsets.UTF_8;
        Charset c2 = Charset.forName("ISO-8859-2");

        byte[] bytes = new byte[] {-59, -95, -60, -111, -60, -115, -60, -121, -59, -66};
        String text = new String(bytes, c); // šđčćž po UTF8

        byte[] bytes2 = text.getBytes(c2); //-71 -16 -24 -26 -66

        System.out.println(Arrays.toString(bytes));
        System.out.println(text);
        System.out.println(Arrays.toString(bytes2));
        System.out.println(new String(bytes2, c2));
    }
}
