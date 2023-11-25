package default_library;

import java.util.Arrays;
import java.util.stream.Stream;

public class Stream_mapToInt {
    public static void main(String[] args) {
        String[] numbers = { "1", "2", "3", "4", "5" };

        // 문자열 배열을 int 스트림으로 변환
        int sum = Stream.of(numbers)
                .mapToInt(Integer::parseInt) // 각 문자열을 정수로 변환
                .sum();

        System.out.println("합계: " + sum);

        // 직접 정의한 람다표현식을 사용
        int[] squared = Stream.of(numbers)
                .mapToInt(num -> Integer.parseInt(num) * Integer.parseInt(num)) // 제곱을 계산하는 람다 표현식
                .toArray();
        System.out.println("각 요소를 제곱: " + Arrays.toString(squared));

        // 직접 메서드를 정의
        int[] otherCalculations = Stream.of(numbers)
                .mapToInt(num -> {
                    int number = Integer.parseInt(num);
                    return number * 2 + 3;
                })
                .toArray();

        System.out.println("2x + 3: " + Arrays.toString(otherCalculations));
    }
}
