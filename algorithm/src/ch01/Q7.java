package ch01;

import java.util.Scanner;

//가우스의 덧셈
public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1~n 까지의 합을 구한다.");
        System.out.print("n의 값> ");
        int n = sc.nextInt();
        int sum = 0;

        if(n%2 == 0) {
            sum = (1 + n) * n / 2;
        } else {
            sum = ((n + 1) * (n / 2))+( ( n / 2 ) +1 );
        }

        System.out.println("n까지의 합은 : " + sum);
    }

}
