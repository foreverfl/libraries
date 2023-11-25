package default_library;

import java.io.IOException;
import java.io.StringWriter;

public class StringWriterExample {
    public static void main(String[] args) throws IOException {
        StringWriter writer = new StringWriter();

        writer.write("Hello, ");
        writer.write("world!");

        String result = writer.toString();
        System.out.println(result);

        writer.close();
    }
}
