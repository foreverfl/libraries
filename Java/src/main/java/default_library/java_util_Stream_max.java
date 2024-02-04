package default_library;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class java_util_Stream_max {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 방법 1: Integer::compare 메서드 참조
        numbers.stream()
                .max(Integer::compare)
                .ifPresent(System.out::println); // 5 출력

        // 방법 2: Comparator.naturalOrder() 사용
        numbers.stream()
                .max(Comparator.naturalOrder())
                .ifPresent(System.out::println); // 5 출력

        // 방법 3: 람다 표현식 사용
        numbers.stream()
                .max((a, b) -> a.compareTo(b))
                .ifPresent(System.out::println); // 5 출력
    }
}
