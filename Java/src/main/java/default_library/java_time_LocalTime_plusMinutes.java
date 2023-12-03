package default_library;

import java.time.LocalTime;

public class java_time_LocalTime_plusMinutes {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(20, 45);
        System.out.println("LocalTime: " + time);
        LocalTime newTime = time.plusMinutes(30); // 30분 추가
        System.out.println("New LocalTime: " + newTime);
    }
}
