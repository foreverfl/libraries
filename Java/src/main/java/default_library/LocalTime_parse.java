package default_library;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTime_parse {
    public class LocalTimeParseExample {
        public static void main(String[] args) {
            String timeString = "20:45";
            LocalTime time = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));
            System.out.println("Parsed LocalTime: " + time);
        }
    }
}
