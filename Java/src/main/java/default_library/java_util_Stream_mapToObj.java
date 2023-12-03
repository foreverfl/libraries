package default_library;

import java.util.stream.IntStream;

public class java_util_Stream_mapToObj {
    public static void main(String[] args) {
        IntStream.range(1, 5) // 1부터 4까지의 숫자 스트림을 생성
                .mapToObj(i -> i * i) // 각 요소를 제곱으로 매핑
                .forEach(System.out::println);
    }
}
