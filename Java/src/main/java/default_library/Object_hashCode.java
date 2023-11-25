package default_library;

public class Object_hashCode {
    static class MyObject {
        int value;

        MyObject(int value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(value);
        }
    }

    public static void main(String[] args) {
        MyObject obj1 = new MyObject(5);
        MyObject obj2 = new MyObject(5);

        System.out.println("Hash code of obj1: " + obj1.hashCode());
        System.out.println("Hash code of obj2: " + obj2.hashCode());
    }
}
