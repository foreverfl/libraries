package default_library;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Collections_swap {
    public static void main(String[] args) {
        // 원본 리스트
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");

        System.out.println("Original List: " + list);

        // 첫 번째 요소와 두 번째 요소의 위치를 바꿈
        Collections.swap(list, 0, 1);

        System.out.println("After swapping first and second elements: " + list);

        // 첫 번째 요소와 세 번째 요소의 위치를 바꿈
        Collections.swap(list, 0, 2);

        System.out.println("After swapping first and third elements: " + list);
    }
}
