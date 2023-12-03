package default_library;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class java_util_HashSet {
    static class Object1 {
        int x, y;

        Object1(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Object1 pair = (Object1) obj;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Object2 {
        int x, y;

        Object2(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) {
        // Object1은 hashCode()를 오버라이드
        Set<Object1> set1 = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            set1.add(new Object1(1, 1));
        }

        System.out.println("Size of the set: " + set1.size());

        // Object2은 hashCode()를 오버라이드 하지 않음
        Set<Object2> set2 = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            set2.add(new Object2(1, 1));
        }

        System.out.println("Size of the set: " + set2.size());
    }
}
