package default_library;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class LocalDate_of {
    public static void main(String[] args) {
        // 현재 날짜를 나타내는 LocalDate 인스턴스 생성
        LocalDate today = LocalDate.now();
        System.out.println("오늘 날짜: " + today);

        // 특정 날짜를 나타내는 LocalDate 인스턴스 생성
        LocalDate specificDate = LocalDate.of(2023, 11, 9);
        System.out.println("특정 날짜: " + specificDate);

        // 오늘 날짜에 하루를 더함
        LocalDate tomorrow = today.plusDays(1);
        System.out.println("내일 날짜: " + tomorrow);

        // 오늘 날짜에 1주를 더함
        LocalDate nextWeek = today.plusWeeks(1);
        System.out.println("다음 주 날짜: " + nextWeek);

        // 오늘 날짜에 한 달을 더함
        LocalDate nextMonth = today.plusMonths(1);
        System.out.println("다음 달 날짜: " + nextMonth);

        // 오늘 날짜에 1년을 더함
        LocalDate nextYear = today.plusYears(1);
        System.out.println("내년 날짜: " + nextYear);

        // 오늘 날짜에서 하루를 뺌
        LocalDate yesterday = today.minusDays(1);
        System.out.println("어제 날짜: " + yesterday);

        // 오늘 날짜의 '일' 부분을 가져옴
        int dayOfMonth = today.getDayOfMonth();
        System.out.println("이 달의 일: " + dayOfMonth);

        // 오늘 날짜의 요일을 가져옴
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        System.out.println("오늘의 요일: " + dayOfWeek);

        // 오늘 날짜가 해당 연도의 몇 번째 날인지 가져옴
        int dayOfYear = today.getDayOfYear();
        System.out.println("이 해의 일: " + dayOfYear);

        // 연도를 2024로 변경
        LocalDate nextYearToday = today.withYear(2024);
        System.out.println("2024년의 오늘 날짜: " + nextYearToday);

        // 월을 1월로 변경
        LocalDate firstMonthToday = today.withMonth(1);
        System.out.println("1월의 오늘 날짜: " + firstMonthToday);

        // '일'을 1일로 변경
        LocalDate firstDayToday = today.withDayOfMonth(1);
        System.out.println("이 달의 첫 날: " + firstDayToday);
    }
}
