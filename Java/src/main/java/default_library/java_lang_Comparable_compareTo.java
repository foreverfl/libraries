package default_library;

import java.util.Arrays;

public class java_lang_Comparable_compareTo {
    static class Person implements Comparable<Person> {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // 오름차순 정렬을 위한 compareTo 메소드
        @Override
        public int compareTo(Person other) {
            return this.age - other.age; // 나이 기준 오름차순 정렬
        }

        @Override
        public String toString() {
            return name + ": " + age;
        }
    }

    static class Dog implements Comparable<Dog> {
        String name;
        int age;

        public Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // 이름 기준으로 오름차순 정렬
        @Override
        public int compareTo(Dog other) {
            return this.name.compareTo(other.name);
        }

        @Override
        public String toString() {
            return name + ": " + age;
        }
    }

    static class Cat implements Comparable<Cat> {
        String name;
        int age;

        public Cat(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // 안전한 정수 비교를 위한 compareTo 구현
        @Override
        public int compareTo(Cat other) {
            return Integer.compare(this.age, other.age);
        }

        @Override
        public String toString() {
            return name + ": " + age;
        }
    }

    public static void main(String[] args) {
        Person[] people = {
                new Person("Alice", 32),
                new Person("Bob", 24),
                new Person("Charlie", 28)
        };

        Dog[] dogs = {
                new Dog("Rex", 5),
                new Dog("Spot", 2),
                new Dog("Fido", 3)
        };

        Cat[] cats = {
                new Cat("Whiskers", 3),
                new Cat("Tiger", 5),
                new Cat("Lucy", 4)
        };

        // 사람들을 나이순으로 정렬
        Arrays.sort(people);
        System.out.println("People sorted by age:");
        for (Person p : people) {
            System.out.println(p);
        }

        // 개를 이름순으로 정렬
        Arrays.sort(dogs);
        System.out.println("\nDogs sorted by name:");
        for (Dog d : dogs) {
            System.out.println(d);
        }

        // 고양이들을 나이순으로 정렬
        Arrays.sort(cats);
        System.out.println("\nCats sorted by age:");
        for (Cat c : cats) {
            System.out.println(c);
        }
    }
}
