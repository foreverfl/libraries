package default_library;

import java.util.HashMap;

public class java_util_HashMap_getOrDefault {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("사과", 10);
        map.put("바나나", 5);

        // '사과'의 값 가져오기 - '사과'는 맵에 존재하므로 해당 값 반환
        int appleCount = map.getOrDefault("사과", 0);
        System.out.println("사과의 수: " + appleCount);

        // '오렌지'의 값 가져오기 - '오렌지'는 맵에 없으므로 기본값 0 반환
        int orangeCount = map.getOrDefault("오렌지", 0);
        System.out.println("오렌지의 수: " + orangeCount);
    }
}
