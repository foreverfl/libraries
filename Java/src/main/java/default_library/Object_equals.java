package default_library;

public class Object_equals {
    static class MyObject {
        int value;

        MyObject(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass()) { // 두 객체가 동일한 클래스의 인스턴스인지 확인
                return false;
            }

            MyObject myObject = (MyObject) obj; // 해당 클래스의 필드에 안전하게 접근하기 위해 타입 캐스팅
            return value == myObject.value;
        }
    }

    public static void main(String[] args) {
        MyObject obj1 = new MyObject(5);
        MyObject obj2 = new MyObject(5);
        MyObject obj3 = new MyObject(10);

        System.out.println("obj1 equals obj2: " + obj1.equals(obj2)); // true
        System.out.println("obj1 equals obj3: " + obj1.equals(obj3)); // false
    }
}
