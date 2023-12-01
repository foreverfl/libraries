package redis;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

public class _02_Data_type_01_Strings {
    public static void main(String[] args) {

        // 연결
        Jedis jedis = JedisManager.getJedisInstance();

        // 문자열을 set/get함
        String res1 = jedis.set("bike:1", "Deimos");
        System.out.println(res1); // OK
        String res2 = jedis.get("bike:1");
        System.out.println(res2); // Deimos
        System.out.println("===================================");

        // 옵션을 사용해서 set
        Long res3 = jedis.setnx("bike:1", "bike"); // set if not exists
        System.out.println(res3); // 0
        System.out.println(jedis.get("bike:1")); // value는 바뀌지 않음
        String res4 = jedis.set("bike:1", "bike", SetParams.setParams().xx()); // key가 존재한다면 set
        System.out.println(res4); // OK
        System.out.println("===================================");

        // 여러개의 문자열을 동시에 set
        String res5 = jedis.mset("bike:1", "Deimos", "bike:2", "Ares", "bike:3", "Vanth");
        System.out.println(res5); // OK
        List<String> res6 = jedis.mget("bike:1", "bike:2", "bike:3");
        System.out.println(res6); // [Deimos, Ares, Vanth]
        System.out.println("===================================");

        // 문자열을 통한 카운팅
        jedis.set("total_crashes", "0");
        Long res7 = jedis.incr("total_crashes");
        System.out.println(res7); // 1
        Long res8 = jedis.incrBy("total_crashes", 10);
        System.out.println(res8); // 11
        System.out.println("===================================");
    }
}
