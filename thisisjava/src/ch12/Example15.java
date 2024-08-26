package ch12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Example15 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("현재 날짜 :" + now.format(dtf));

        LocalDateTime lastDay = LocalDateTime.of(2024,12,31,0,0,0);

        long remainDay = now.until(lastDay, ChronoUnit.DAYS);

        System.out.println("올해 12월 31일 까지 남은 일 수는 : " + remainDay);
    }
}
