package default_library;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class OptionalInt_getAsInt {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5 };

        // 스트림을 사용하여 최솟값 찾기
        OptionalInt min = IntStream.of(numbers).min();

        // 최솟값이 존재하는지 확인하고 값을 가져오기
        if (min.isPresent()) {
            System.out.println("최솟값: " + min.getAsInt());
        } else {
            System.out.println("배열이 비어 있습니다.");
        }
    }
}
