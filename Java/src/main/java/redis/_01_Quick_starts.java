package redis;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class _01_Quick_starts {
    public static void main(String[] args) {
        // 연결
        Jedis jedis = JedisManager.getJedisInstance();

        // 단일 데이터 저장
        String setStatus = jedis.set("bike:1", "Process 134");
        if ("OK".equals(setStatus)) {
            System.out.println("Successfully added a bike.");
        }

        // 단일 데이터 조회
        String bike1Value = jedis.get("bike:1");
        if (bike1Value != null) {
            System.out.println("The name of the bike is: " + bike1Value + ".");
        }

        System.out.println("=====================================");

        // 해시 데이터 저장
        Map<String, String> bike2Details = new HashMap<>();
        bike2Details.put("model", "Deimos");
        bike2Details.put("brand", "Ergonom");
        bike2Details.put("type", "Enduro bikes");
        bike2Details.put("price", "4972");

        Long hsetResult = jedis.hset("bike:2", bike2Details);
        System.out.println("Number of fields added to bike:2 - " + hsetResult);

        // 개별 필드 조회
        String bike2Model = jedis.hget("bike:2", "model");
        System.out.println("Model of bike:2 - " + bike2Model);

        String bike2Price = jedis.hget("bike:2", "price");
        System.out.println("Price of bike:2 - " + bike2Price);

        // 해시 데이터 조회
        Map<String, String> bike2FullDetails = jedis.hgetAll("bike:2");
        System.out.println("Details of bike:2 - " + bike2FullDetails);

        jedis.close();
    }
}
