package default_library;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class java_util_Stream_collect {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Java", "Python", "C++", "JavaScript");
        List<String> list = stream.collect(Collectors.toList()); // 스트림을 리스트로 변환
        System.out.println(list);
    }
}
