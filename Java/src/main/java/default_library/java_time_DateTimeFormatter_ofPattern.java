package default_library;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class java_time_DateTimeFormatter_ofPattern {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();

        // ISO 날짜 시간 형식
        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_DATE_TIME;
        String isoFormatted = dateTime.format(isoFormatter);
        System.out.println("ISO DateTime: " + isoFormatted);

        // 사용자 정의 형식: yyyy-MM-dd HH:mm:ss
        DateTimeFormatter customFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String customFormatted1 = dateTime.format(customFormatter1);
        System.out.println("Custom DateTime 1: " + customFormatted1);

        // 다른 사용자 정의 형식: EEEE, MMMM dd, yyyy HH:mm
        DateTimeFormatter customFormatter2 = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy HH:mm");
        String customFormatted2 = dateTime.format(customFormatter2);
        System.out.println("Custom DateTime 2: " + customFormatted2);

        // 단축된 형식: MM/dd/yyyy
        DateTimeFormatter shortDateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String shortDateFormatted = dateTime.format(shortDateFormatter);
        System.out.println("Short Date: " + shortDateFormatted);

        // 시간만 포맷팅: HH시 mm분 ss초
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
        String timeFormatted = dateTime.format(timeFormatter);
        System.out.println("Formatted Time: " + timeFormatted);
    }
}
