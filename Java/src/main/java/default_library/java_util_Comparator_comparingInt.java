package default_library;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class java_util_Comparator_comparingInt {

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " - " + age;
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 32));
        people.add(new Person("Bob", 24));
        people.add(new Person("Charlie", 28));

        // 나이(age)로 오름차순 정렬
        people.sort(Comparator.comparingInt(p -> p.age));
        System.out.println("오름차순 정렬: " + people);

        // 나이(age)로 내림차순 정렬
        people.sort(Comparator.comparingInt((Person p) -> p.age).reversed()); // reversed()를 쓸 때 컴파일러가 타입 추론을 못하는 경우가 있어
                                                                              // 타입을 명시해줘야함
        System.out.println("내림차순 정렬: " + people);

        // 나이가 짝수인 사람을 먼저 정렬 (나이가 짝수인 경우 -1, 홀수인 경우 1을 반환)
        people.sort((p1, p2) -> (p1.age % 2 == 0 ? -1 : 1) - (p2.age % 2 == 0 ? -1 : 1));
        System.out.println("기타 정렬 (나이가 짝수인 사람 우선): " + people);
    }
}

// reference:
// https://stackoverflow.com/questions/25172595/comparator-reversed-does-not-compile-using-lambda