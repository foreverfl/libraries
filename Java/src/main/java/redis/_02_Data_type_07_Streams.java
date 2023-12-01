package redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.StreamEntryID;
import redis.clients.jedis.params.XReadGroupParams;
import redis.clients.jedis.params.XReadParams;
import redis.clients.jedis.resps.StreamEntry;
import redis.clients.jedis.resps.StreamGroupInfo;

public class _02_Data_type_07_Streams {

    public static StreamEntryID check;

    public static void main(String[] args) {
        Jedis jedis = JedisManager.getJedisInstance();

        try {
            jedis.del("stream");
            String streamKey = "stream";

            // XADD: Stream에 새로운 항목 추가
            addJapaneseNamesToStream(jedis, streamKey, 30);

            // XRANGE: 특정 범위의 Stream 항목 조회
            List<StreamEntry> entries = jedis.xrange(streamKey, StreamEntryID.MINIMUM_ID, StreamEntryID.MAXIMUM_ID);
            for (StreamEntry entry : entries) {
                System.out.println("Entry ID: " + entry.getID() + ", Data: " + entry.getFields());
            }
            System.out.println("==================================================================");

            // XLEN: Stream의 길이 확인
            long streamLength = jedis.xlen(streamKey);
            System.out.println("Length of the stream: " + streamLength);
            System.out.println("==================================================================");

            // XREAD: Stream에서 새로운 항목을 실시간으로 읽기
            XReadParams params = new XReadParams();

            params.count(3); // 한 번에 읽을 스트림 항목의 최대 개수를 지정
            params.block(0); // 새 항목이 스트림에 도착할 때까지 대기하는 시간(밀리초 단위). 0은 제한없음을 의미함.

            Map<String, StreamEntryID> streams = new HashMap<>();
            streams.put(streamKey, check); // 시작 위치 설정

            List<Entry<String, List<StreamEntry>>> readEntries = jedis.xread(params, streams);
            for (Entry<String, List<StreamEntry>> entry : readEntries) {
                System.out.println("Read entry: " + entry);
            }
            System.out.println("==================================================================");

            // XGROUP: 컨슈머 그룹 생성
            String groupName = "consumerGroup";
            // 3번째 parameter - new StreamEntryID("0-0"): 컨슈머 그룹이 메시지를 읽기 시작할 스트림 내의 시작 지점.
            // 0-0은 처음부터 읽기 시작하겠다는 의미.
            // 4번째 parameter - true: 컨슈머 그룹이 이미 존재할 경우 그룹을 대체하겠다는 의미
            String isCreated = jedis.xgroupCreate(streamKey, groupName, new StreamEntryID("0-0"), true);
            System.out.println("is created?: " + isCreated);
            System.out.println("==================================================================");

            // XREADGROUP: 컨슈머 그룹을 통해 메시지 읽기
            // XACK: 메시지 처리 확인
            XReadGroupParams xReadGroupParams = new XReadGroupParams(); // XREADGROUP 명령의 추가 매개변수를 설정하는데 사용
            Map<String, StreamEntryID> streamsWithIDs = new HashMap<>();
            streamsWithIDs.put(streamKey, StreamEntryID.UNRECEIVED_ENTRY);
            List<Entry<String, List<StreamEntry>>> groupEntries = jedis.xreadGroup(groupName, "consumer1",
                    xReadGroupParams,
                    streamsWithIDs);
            for (Entry<String, List<StreamEntry>> streamEntry : groupEntries) {
                for (StreamEntry entry : streamEntry.getValue()) {
                    String email = entry.getFields().get("email");
                    if (email != null && email.endsWith("@example1.com")) {
                        System.out.println("Processing entry: " + entry); // example1.com 이메일을 가진 메시지만 처리
                        jedis.xack(streamKey, groupName, entry.getID());
                    }
                }
            }

            // jedis.xinfoGroups로 결과 확인하기
            List<StreamGroupInfo> groups = jedis.xinfoGroups(streamKey); // 스트림의 컨슈머 그룹 정보 가져오기
            for (StreamGroupInfo group : groups) {
                System.out.println("Group Name: " + group.getName());
                System.out.println("Consumers: " + group.getConsumers()); // 컨슈머는 XREADGROUP을 통해 메시지를 읽을 때 그룹에 등록됨
                System.out.println("Pending: " + group.getPending()); // 처리를 대기 중인 메시지의 수
                System.out.println("Last Delivered ID: " + group.getLastDeliveredId()); // 이 그룹에 마지막으로 배달된 메시지의 ID
            }
            System.out.println("==================================================================");

        } finally {
            // Redis 연결 종료
            jedis.close();
        }
    }

    private static void addJapaneseNamesToStream(Jedis jedis, String streamKey, int count) {
        String[] names = { "Haruka", "Yuki", "Nao", "Rin", "Aoi", "Sora", "Kai", "Rio", "Mei", "Saki" };
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            Map<String, String> data = new HashMap<>();
            String name = names[random.nextInt(names.length)];
            data.put("name", name);
            if (i % 2 == 0) {
                data.put("email", name.toLowerCase() + "@example1.com");
            } else {
                data.put("email", name.toLowerCase() + "@example2.com");
            }

            StreamEntryID entryId = jedis.xadd(streamKey, StreamEntryID.NEW_ENTRY, data);
            if (i == 0) {
                check = entryId;
                System.out.println("Added entry: " + entryId);
            }
        }

        System.out.println("==================================================================");
    }
}
