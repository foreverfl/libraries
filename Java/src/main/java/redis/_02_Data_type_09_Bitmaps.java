package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.args.BitOP;

public class _02_Data_type_09_Bitmaps {
    public static void main(String[] args) {
        Jedis jedis = JedisManager.getJedisInstance();

        try {
            String key = "bitmapKey";
            jedis.del("bitmapKey", "bitmapKey2", "bitmapOpResult");

            // SETBIT: 지정된 오프셋에 비트를 설정
            jedis.setbit(key, 0, true); // 0번 위치를 1로 설정
            jedis.setbit(key, 1, false); // 1번 위치를 0으로 설정
            jedis.setbit(key, 2, true); // 2번 위치를 1로 설정

            // GETBIT: 지정된 오프셋의 비트 값 가져오기
            boolean bitValue0 = jedis.getbit(key, 0);
            boolean bitValue1 = jedis.getbit(key, 1);
            System.out.println("Bit at offset 0: " + bitValue0); // true
            System.out.println("Bit at offset 1: " + bitValue1); // false
            System.out.println("==================================================================");

            // BITOP: 비트 연산 수행
            String key2 = "bitmapKey2";
            jedis.setbit(key2, 0, false);
            jedis.setbit(key2, 1, true);
            jedis.setbit(key2, 2, true);

            String keyOpResult = "bitmapOpResult";
            jedis.bitop(BitOP.AND, keyOpResult, key, key2); // key와 key2의 AND 연산 결과를 keyOpResult에 저장

            // BITOP 결과 확인
            boolean bitOpValue0 = jedis.getbit(keyOpResult, 0);
            boolean bitOpValue1 = jedis.getbit(keyOpResult, 1);
            boolean bitOpValue2 = jedis.getbit(keyOpResult, 2);
            System.out.println("BitOp Result at offset 0: " + bitOpValue0); // false (1 AND 0)
            System.out.println("BitOp Result at offset 1: " + bitOpValue1); // false (0 AND 1)
            System.out.println("BitOp Result at offset 2: " + bitOpValue2); // true (1 AND 1)
        } finally {
            // Redis 연결 종료
            jedis.close();
        }
    }
}
