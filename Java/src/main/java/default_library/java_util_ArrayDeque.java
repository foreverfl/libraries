package default_library;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class java_util_ArrayDeque {
    public static void main(String[] args) {
        int operations = 10000000; // 많은 수의 연산을 수행

        // LinkedList를 사용한 시간 측정
        Queue<Integer> linkedListQueue = new LinkedList<>();
        long startTimeLinkedList = System.currentTimeMillis();
        for (int i = 0; i < operations; i++) {
            linkedListQueue.add(i);
        }
        for (int i = 0; i < operations; i++) {
            linkedListQueue.poll();
        }
        long endTimeLinkedList = System.currentTimeMillis();
        System.out.println("LinkedList: " + (endTimeLinkedList - startTimeLinkedList) + " ms");

        // ArrayDeque를 사용한 시간 측정
        Queue<Integer> arrayDequeQueue = new ArrayDeque<>();
        long startTimeArrayDeque = System.currentTimeMillis();
        for (int i = 0; i < operations; i++) {
            arrayDequeQueue.add(i);
        }
        for (int i = 0; i < operations; i++) {
            arrayDequeQueue.poll();
        }
        long endTimeArrayDeque = System.currentTimeMillis();
        System.out.println("ArrayDeque: " + (endTimeArrayDeque - startTimeArrayDeque) + " ms");
    }
}
