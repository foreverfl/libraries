package default_library;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class java_util_HashMap_values {
    public static void main(String[] args) {
        // HashMap 생성 및 요소 추가
        Map<String, Integer> map = new HashMap<>();
        map.put("사과", 10);
        map.put("바나나", 20);
        map.put("오렌지", 30);

        // values() 메서드를 사용하여 값의 컬렉션 뷰를 얻음
        Collection<Integer> values = map.values();
        System.out.println("values 타입 확인: " + values.getClass().getName());

        // 컬렉션 뷰를 사용하여 모든 값을 출력
        for (Integer value : values) {
            System.out.println(value);
        }

        // 맵에 변화를 주고, 컬렉션 뷰에 반영되는지 확인
        map.put("체리",  50); // 새로운 요소 추가
        map.remove("사과"); // 기존 요소 삭제

        // 다시 모든 값을 출력하여 변경 사항 반영 확인
        System.out.println("\n변경 후 값:");
        for (Integer value : values) {
            System.out.println(value);
        }
    }
}