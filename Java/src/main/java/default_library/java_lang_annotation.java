package default_library;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class java_lang_annotation {
    @Target(ElementType.METHOD) // 메서드에 적용되는 어노테이션
    @Retention(RetentionPolicy.RUNTIME) // 런타임에도 유지
    public @interface Greeting {
        String message() default "Hello"; // 인사말 메시지, 기본값 "Hello"

        String from() default "Anonymous"; // 보낸 사람, 기본값 "Anonymous"
    }

    public static class Hello {
        @Greeting
        public void hello() throws NoSuchMethodException, SecurityException {
            Greeting greeting = this.getClass().getMethod("hello").getAnnotation(Greeting.class);
            if (greeting != null) {
                System.out.println(greeting.message() + " from " + greeting.from());
            }
        }

        @Greeting(message = "Good morning!", from = "Haruka")
        public void morningHello() throws NoSuchMethodException, SecurityException {
            Greeting greeting = this.getClass().getMethod("morningHello").getAnnotation(Greeting.class);
            if (greeting != null) {
                System.out.println(greeting.message() + " from " + greeting.from());
            }
        }

        @Greeting(message = "Good afternoon!", from = "Haruka")
        public void nightHello() throws NoSuchMethodException, SecurityException {
            Greeting greeting = this.getClass().getMethod("nightHello").getAnnotation(Greeting.class);
            if (greeting != null) {
                System.out.println(greeting.message() + " from " + greeting.from());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Hello hello = new Hello();
        hello.hello();
        hello.morningHello();
        hello.nightHello();
    }
}
