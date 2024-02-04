package default_library;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class java_util_Stream_filter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(filteredNames); // [Alice] 출력
    }
}
