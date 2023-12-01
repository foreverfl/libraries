package redis;

import java.util.List;

import redis.clients.jedis.Jedis;

public class _02_Data_type_06_Sorted_sets {
    public static void main(String[] args) {
        Jedis jedis = JedisManager.getJedisInstance();
        // Leaderboards 또는 Rate limiter(접속 요청 제한)에 사용됨

        // Sorted Set에 멤버 추가 (ZADD)
        jedis.del("Sortedset");
        jedis.zadd("SortedSet", 1, "member1");
        jedis.zadd("SortedSet", 2, "member2");
        jedis.zadd("SortedSet", 3, "member3");
        jedis.zadd("SortedSet", 4, "member4");
        jedis.zadd("SortedSet", 5, "member5");
        List<String> sortedSet = jedis.zrange("SortedSet", 0, -1);
        System.out.println("SortedSet: " + sortedSet);
        System.out.println("==================================================================");

        // Sorted Set의 모든 멤버 조회 (ZRANGE) - 점수 오름차순
        List<String> sortedSetAsc = jedis.zrange("SortedSet", 0, -1);
        System.out.println("Sorted Set Ascending: " + sortedSetAsc);
        System.out.println("==================================================================");

        // Sorted Set의 모든 멤버 조회 (ZREVRANGE) - 점수 내림차순
        List<String> sortedSetDesc = jedis.zrevrange("SortedSet", 0, -1);
        System.out.println("Sorted Set Descending: " + sortedSetDesc);
        System.out.println("==================================================================");

        // Sorted Set에서 멤버 제거 (ZREM)
        jedis.zrem("SortedSet", "member3");
        List<String> afterRemoval = jedis.zrange("SortedSet", 0, -1);
        System.out.println("After Removing member3: " + afterRemoval);
        System.out.println("==================================================================");

        // 특정 점수 범위의 멤버 조회 (ZRANGEBYSCORE)
        List<String> scoreRange = jedis.zrangeByScore("SortedSet", 1, 2);
        System.out.println("Members with score 1 to 2: " + scoreRange);
        System.out.println("==================================================================");

        // 멤버의 점수 확인 (ZSCORE)
        Double memberScore = jedis.zscore("SortedSet", "member1");
        System.out.println("Score of member1: " + memberScore);
        System.out.println("==================================================================");

        // Sorted Set의 크기 확인 (ZCARD)
        long setSize = jedis.zcard("SortedSet");
        System.out.println("Size of Sorted Set: " + setSize);
        System.out.println("==================================================================");

        // Redis 연결 종료
        jedis.close();

    }
}
