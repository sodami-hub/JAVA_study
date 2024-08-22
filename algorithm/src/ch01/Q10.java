package ch01;

import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int a = sc.nextInt();

        int i = 1;
        int j = 0;
        int res = 0;

        do {
            j = a/i;
            i *=10;
            res += 1;
        }while(j > 1);

        System.out.println("입력한 정수의 자릿수는 "+res+"자리 입니다.");
    }
}
