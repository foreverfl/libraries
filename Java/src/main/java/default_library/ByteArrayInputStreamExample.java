package default_library;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamExample {
    public static void main(String[] args) {
        System.out.println("getBytes(): " + "Hello, world!".getBytes());

        byte[] data = "Hello, world!".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);

        int byteData;
        while ((byteData = inputStream.read()) != -1) {
            System.out.print((char) byteData);
        }

        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
