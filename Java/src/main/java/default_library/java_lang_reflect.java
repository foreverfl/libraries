package default_library;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class java_lang_reflect {

    @SuppressWarnings("unused")
    static class SampleClass {
        private String name;
        private int value;

        public void printInfo() {
            System.out.println("Printing Info");
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Class<SampleClass> cls = SampleClass.class;

        // 메서드 정보 출력
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method Name: " + method.getName());
        }

        // 필드 정보 출력
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field Name: " + field.getName());
        }
    }
}
