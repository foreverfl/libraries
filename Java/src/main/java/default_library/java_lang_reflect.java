package default_library;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class java_lang_reflect {

    public static void main(String[] args) {
        try {
            // 1. 클래스의 정보 가져오기
            Class<?> clazz = Class.forName("java.util.ArrayList");
            System.out.println(clazz);

            // 2. 클래스의 모든 메소드 출력하기
            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.getName());
            }
            System.out.println();

            // 3. 클래스의 모든 필드 출력하기
            System.out.println("\nFields:");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getName());
            }

            // 4. 클래스의 객체 생성하기 및 출력
            System.out.println("\nObject:");
            Constructor<?> constructor = clazz.getConstructor();
            Object instance = constructor.newInstance();
            System.out.println(instance); // ArrayList 인스턴스 생성 확인

            // 5. 생성된 객체의 메소드 호출하기 및 결과 출력
            System.out.println("\nCalling Method:");
            Method addMethod = clazz.getMethod("add", Object.class);
            addMethod.invoke(instance, "Hello Reflection"); // 메소드 호출로 "Hello Reflection" 추가
            System.out.println(instance); // instance.toString()이 호출되어 현재 ArrayList의 내용이 출력됨

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
