package ch12;

import java.util.StringTokenizer;

public class Example11 {
    public static void main(String[] args) {
        String str = "아이디,이름,패스워드";
        System.out.println(str);

        StringTokenizer st = new StringTokenizer(str, ",");

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
