package redis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class tmp {
    public static void main(String[] args) throws IOException {

        String currentDir = System.getProperty("user.dir");
        System.out.println(currentDir);
        InputStream input = new FileInputStream(currentDir + File.separator +
                "java\\redis.properties");
        System.out.println(input);

    }
}
