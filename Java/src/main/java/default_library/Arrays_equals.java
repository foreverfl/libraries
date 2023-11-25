package default_library;

import java.util.Arrays;

public class Arrays_equals {
    public static void main(String[] args) {
        // 두 개의 배열을 초기화
        int[] array1 = { 1, 2, 3, 4, 5 };
        int[] array2 = { 1, 2, 3, 4, 5 };
        int[] array3 = { 5, 4, 3, 2, 1 };

        // array1과 array2 비교
        boolean areArray1AndArray2Equal = Arrays.equals(array1, array2);
        System.out.println("array1과 array2가 같습니까? " + areArray1AndArray2Equal);

        // array1과 array3 비교
        boolean areArray1AndArray3Equal = Arrays.equals(array1, array3);
        System.out.println("array1과 array3가 같습니까? " + areArray1AndArray3Equal);
    }
}
