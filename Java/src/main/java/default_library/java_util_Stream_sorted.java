package default_library;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class java_util_Stream_sorted {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 3, 5, 1, 2);
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNumbers); // [1, 2, 3, 4, 5] 출력
    }
}
