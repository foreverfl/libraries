package default_library;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class java_util_stream_Collectors_toList {
    public static void main(String[] args) {
        // 초기 문자열 리스트
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Carole", "Eve");

        // 'C'로 시작하는 이름만 선택
        List<String> namesStartingWithC = names.stream()
                .filter(name -> name.startsWith("C"))
                .collect(Collectors.toList());

        // 결과 출력
        System.out.println(namesStartingWithC);
    }
}
