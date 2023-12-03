package default_library;

import java.util.Arrays;

public class java_util_Arrays_deepEquals {
    public static void main(String[] args) {
        // 두 개의 2차원 정수 배열을 초기화
        int[][] array1 = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] array2 = { { 1, 2, 3 }, { 4, 5, 6 } };

        // 두 배열이 내용적으로 같은지 확인
        boolean areArraysEqual = Arrays.deepEquals(array1, array2);

        // 결과 출력
        if (areArraysEqual) {
            System.out.println("두 배열은 같습니다.");
        } else {
            System.out.println("두 배열은 다릅니다.");
        }

        // 서로 다른 내용을 가진 배열 비교
        int[][] array3 = { { 7, 8, 9 }, { 10, 11, 12 } };

        // array1과 array3 비교
        areArraysEqual = Arrays.deepEquals(array1, array3);

        // 결과 출력
        if (areArraysEqual) {
            System.out.println("두 배열은 같습니다.");
        } else {
            System.out.println("두 배열은 다릅니다.");
        }
    }
}
