package default_library;

import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) {
        // Properties 객체 생성
        Properties props = new Properties();

        // Properties에 설정 추가
        props.setProperty("username", "user123");
        props.setProperty("password", "mypassword");
        props.setProperty("database", "mydatabase");

        // 설정 값을 읽어오기
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        String database = props.getProperty("database");

        // 값 출력
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Database: " + database);
    }
}
