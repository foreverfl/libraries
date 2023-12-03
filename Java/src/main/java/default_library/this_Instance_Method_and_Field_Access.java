package default_library;

public class this_Instance_Method_and_Field_Access {
    static class Object {
        private int value;

        public Object(int value) {
            this.value = value;
        }

        public void printValue() {
            System.out.println(this.value);
        }
    }

    public static void main(String[] args) {
        Object object = new Object(5);
        object.printValue(); // "5" 출력
    }
}
