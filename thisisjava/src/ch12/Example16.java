package ch12;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Example16 {
    public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분 ss초");

        System.out.println(sdf.format(now));
    }
}
