package redis;

import java.util.List;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.args.ListDirection;

public class _02_Data_type_03_Lists {
    public static void main(String[] args) {

        Jedis jedis = JedisManager.getJedisInstance();

        String listKey = "myList";

        // 리스트에 데이터 추가 (LPUSH, RPUSH)
        jedis.del(listKey); // listKey를 삭제
        jedis.lpush(listKey, "item1", "item2");
        jedis.rpush(listKey, "item3", "item4");
        List<String> allItems = jedis.lrange(listKey, 0, -1); // 리스트 전체 조회
        System.out.println("All items in the list: " + allItems);
        System.out.println("=================================");

        // 리스트에서 데이터 제거 및 반환 (LPOP, RPOP)
        String leftPopItem = jedis.lpop(listKey);
        String rightPopItem = jedis.rpop(listKey);
        System.out.println("Left pop item: " + leftPopItem);
        System.out.println("Right pop item: " + rightPopItem);
        allItems = jedis.lrange(listKey, 0, -1);
        System.out.println("All items in the list: " + allItems);
        System.out.println("=================================");

        // 리스트 길이 확인 (LLEN)
        long listLength = jedis.llen(listKey);
        System.out.println("List length: " + listLength);
        System.out.println("=================================");

        // 리스트의 원소 이동 (LMOVE)
        jedis.del(listKey); // listKey를 삭제
        jedis.lpush(listKey, "item4", "item3", "item2", "item1");
        allItems = jedis.lrange(listKey, 0, -1);
        System.out.println("Before LMOVE: " + allItems);
        jedis.lmove(listKey, listKey, ListDirection.LEFT, ListDirection.RIGHT);
        allItems = jedis.lrange(listKey, 0, -1);
        System.out.println("After LMOVE: " + allItems);
        System.out.println("=================================");

        // 리스트 범위 제한 (LTRIM)
        jedis.del(listKey);
        jedis.lpush(listKey, "item4", "item3", "item2", "item1");
        jedis.ltrim(listKey, 0, 1);
        allItems = jedis.lrange(listKey, 0, -1); // 리스트의 길이를 처음 두 요소로 제한
        System.out.println("After LTRIM: " + allItems);
        System.out.println("=================================");

        // 블로킹 리스트 팝 (BLPOP): 실시간 메시징 시스템, 작업 큐, 이벤트 처리 시스템에서 사용됨
        jedis.del(listKey);
        jedis.lpush(listKey, "item4", "item3", "item2", "item1");
        allItems = jedis.lrange(listKey, 0, -1); // 리스트의 길이를 처음 두 요소로 제한
        System.out.println("Before BLPOP: " + allItems);
        List<String> blpopResult = jedis.blpop(0, listKey); // 타임아웃을 0으로 설정하여 영원히 대기
        System.out.println("BLPOP: " + blpopResult); // [List, 제거된 요소]
        allItems = jedis.lrange(listKey, 0, -1); // 리스트의 길이를 처음 두 요소로 제한
        System.out.println("After LTRIM: " + allItems);

    }
}
