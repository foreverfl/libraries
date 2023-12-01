package redis;

import redis.clients.jedis.Jedis;

public class _02_Data_type_11_HyperLogLog {
    public static void main(String[] args) {
        Jedis jedis = JedisManager.getJedisInstance();

        try {
            String key = "hll_key";
            jedis.del("hll_key", "hll_another_key", "hll_merged_key"); // 초기화

            // PFADD: HyperLogLog에 요소 추가
            jedis.pfadd(key, "item1", "item2", "item3");
            jedis.pfadd(key, "item2", "item4");

            // PFCOUNT: 고유 요소의 근사 개수 확인
            long count = jedis.pfcount(key);
            System.out.println("Estimated unique items count: " + count);
            System.out.println("==================================================================");

            // PFMERGE: 다른 HyperLogLog과 병합
            String anotherKey = "hll_another_key";
            jedis.pfadd(anotherKey, "item5", "item6");

            String mergedKey = "hll_merged_key";
            jedis.pfmerge(mergedKey, key, anotherKey);
            long mergedCount = jedis.pfcount(mergedKey);
            System.out.println("Estimated unique items count after merge: " + mergedCount);
            System.out.println("==================================================================");

        } finally {
            jedis.close();
        }
    }
}
