package default_library;

public class java_lang_Object_getClass {
    static class MyObject {
        // 클래스 본문
    }

    public static void main(String[] args) {
        MyObject obj = new MyObject();

        Class<?> objClass = obj.getClass(); // 제네릭
        System.out.println("Class of obj: " + objClass.getName());
    }
}
