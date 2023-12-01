package redis;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class check_all_keys {
    public static void main(String[] args) {
        Jedis jedis = JedisManager.getJedisInstance();

        // Redis에 저장된 모든 키 조회
        Set<String> allKeys = jedis.keys("*");
        System.out.println("All keys in Redis: " + allKeys);

        // 각 키의 데이터 타입 확인
        for (String key : allKeys) {
            String type = jedis.type(key);
            System.out.println(key + " : " + type);
        }

        jedis.close();
    }
}
