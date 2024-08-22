package ch01;

import java.util.Scanner;

public class Q6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1~n 까지의 합을 구한다.");
        System.out.print("n의 값> ");
        int n = sc.nextInt();

        int sum=0;
        int i =1;

        while (i <= n) {
            sum+=i;
            i+=1;
        }

        System.out.println("1부터 "+n+"까지의 합은 :" +sum +", i의 값은 :" +i);
    }
}
