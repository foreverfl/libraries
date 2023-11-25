package default_library;

import java.io.PrintWriter;
import java.io.StringWriter;

public class PrintWriterExample {
    public static void main(String[] args) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        printWriter.println("Hello, world!");
        printWriter.printf("Number: %d", 123);

        String result = stringWriter.toString();
        System.out.println(result);

        printWriter.close();
    }
}
