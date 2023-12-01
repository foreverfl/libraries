package redis;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class _02_Data_type_04_Sets {
    public static void main(String[] args) {
        Jedis jedis = JedisManager.getJedisInstance();
        // Set에 멤버 추가 (SADD)
        jedis.del("Set1", "Set2");
        jedis.sadd("Set1", "member1", "member2", "member3");
        jedis.sadd("Set2", "member2", "member3", "member4");

        // Set의 모든 멤버 조회 (SMEMBERS)
        Set<String> set1 = jedis.smembers("Set1");
        System.out.println("set1: " + set1);
        System.out.println("=================================");

        // Set에서 멤버 제거 (SREM)
        jedis.srem("Set1", "member3");
        set1 = jedis.smembers("Set1");
        System.out.println("Set1: " + set1);
        System.out.println("=================================");

        // 멤버가 Set에 속하는지 확인 (SISMEMBER)
        boolean isMember = jedis.sismember("Set1", "member2");
        System.out.println("Is member2 in mySet: " + isMember);
        System.out.println("=================================");

        // 두 Set의 교집합 구하기 (SINTER)
        Set<String> intersection = jedis.sinter("Set1", "Set2");
        System.out.println("Intersection of Set1 and Set2: " + intersection);
        System.out.println("=================================");

        // Set의 크기 확인 (SCARD)
        long setSize = jedis.scard("Set1");
        System.out.println("Size of Set1: " + setSize);
        System.out.println("=================================");

    }
}
