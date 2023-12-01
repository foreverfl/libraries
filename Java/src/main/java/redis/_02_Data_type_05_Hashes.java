package redis;

import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class _02_Data_type_05_Hashes {
    public static void main(String[] args) {
        Jedis jedis = JedisManager.getJedisInstance();

        try {
            // Hash에 데이터 저장 (HSET)
            jedis.hset("user:nazuna", "name", "nazuna");
            jedis.hset("user:nazuna", "age", "1000");
            jedis.hset("user:nazuna", "email", "nazuna@gmail.com");
            Map<String, String> userData = jedis.hgetAll("user:nazuna");
            System.out.println("User Data: " + userData);
            System.out.println("==================================================================");

            // 특정 필드의 값 조회 (HGET)
            String name = jedis.hget("user:nazuna", "name");
            System.out.println("Name: " + name);
            System.out.println("==================================================================");

            // 여러 필드의 값 조회 (HMGET)
            List<String> values = jedis.hmget("user:nazuna", "name", "email");
            System.out.println("Values: " + values);
            System.out.println("==================================================================");

            // 특정 필드의 값을 숫자로 증가 (HINCRBY)
            long newAge = jedis.hincrBy("user:nazuna", "age", 1);
            System.out.println("New Age: " + newAge);
            System.out.println("==================================================================");

            // 모든 키-값 쌍 조회 (HGETALL)
            userData = jedis.hgetAll("user:nazuna");
            System.out.println("User Data: " + userData);
            System.out.println("==================================================================");

        } finally {
            // Redis 연결 종료
            jedis.close();
        }
    }
}
