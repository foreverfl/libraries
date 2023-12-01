package redis;

import java.util.List;

import redis.clients.jedis.Jedis;

public class _02_Data_type_10_Bitfields {
    public static void main(String[] args) {
        Jedis jedis = JedisManager.getJedisInstance();

        try {
            String key = "bitfieldKey";
            jedis.del(key);

            // BITFIELD: 비트필드에 대한 복잡한 연산 수행
            // 지정된 오프셋에 5비트 길이의 숫자를 설정
            List<Long> response = jedis.bitfield(
                    key,
                    "SET", "i5", "0", "10", // i5는 5비트 길이의 정수, 0은 오프셋, 10은 설정할 값
                    "GET", "i5", "0" // 동일한 오프셋에서 값을 읽음
            );

            System.out.println("BITFIELD response: " + response); // SET, GET의 값이 차례대로 출력됨
            System.out.println("==================================================================");

            // BITFIELD_RO: 비트필드에서 값 읽기
            // 비트필드 명령은 읽기 전용 버전을 따로 제공하지 않으므로, GET 명령만 사용
            List<Long> readResponse = jedis.bitfield(
                    key,
                    "GET", "i5", "0" // 오프셋 0에서 5비트 길이의 숫자 읽기
            );

            System.out.println("BITFIELD_RO get response: " + readResponse); // GET의 값이 출력됨
            System.out.println("==================================================================");

            // INCRBY: 비트필드 값 증가
            // i5는 -16 ~ 15. u5는 0 ~ 31.
            List<Long> incrResponse = jedis.bitfield(
                    key,
                    "INCRBY", "i5", "0", "1", // 오프셋 0에서 i5 (5비트 부호 있는 정수)를 1만큼 증가
                    "OVERFLOW", "WRAP", // 오버플로우 모드를 WRAP으로 설정. 오버플로우시 값이 순환함.
                    "INCRBY", "i5", "0", "1", // 다시 1만큼 증가
                    "OVERFLOW", "SAT", // 오버플로우 모드를 SAT으로 변경. 오버플로우시 값이 고정됨.
                    "INCRBY", "i5", "0", "32", // 큰 값으로 증가 시도
                    "OVERFLOW", "FAIL", // 오버플로우 모드를 FAIL로 변경. 오버플로우시 null을 리턴함.
                    "INCRBY", "i5", "0", "1" // 오버플로우 발생시 실패 예상
            );

            System.out.println("INCRBY response: " + incrResponse);
            System.out.println("==================================================================");

        } finally {
            jedis.close();
        }
    }
}
