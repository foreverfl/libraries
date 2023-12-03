package default_library;

import java.util.Arrays;

public class java_util_Arrays_binarySearch {
    public static void main(String[] args) {

        int[] numbers = { 2, 4, 6, 8, 10, 12 }; // 정렬된 배열 생성
        int target = 6;

        // target을 찾았을 때
        int result = Arrays.binarySearch(numbers, target);

        if (result >= 0) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }

        // target을 찾지 못했을 때
        target = 3;
        result = Arrays.binarySearch(numbers, target);
        System.out.println(result);

    }
}
