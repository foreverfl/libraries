package redis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;

public class JedisManager {
    private static Jedis jedisInstance;

    private JedisManager() {
        // private 생성자로 인스턴스 생성 방지
    }

    public static Jedis getJedisInstance() {
        if (jedisInstance == null) {
            Properties prop = new Properties();
            String currentDir = System.getProperty("user.dir");
            try (InputStream input = new FileInputStream(currentDir + File.separator + "java\\redis.properties")) {
                prop.load(input);
                String url = prop.getProperty("redis.url");
                String password = prop.getProperty("redis.password");
                jedisInstance = new Jedis("redis://default:" + password + "@" + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jedisInstance;
    }
}
