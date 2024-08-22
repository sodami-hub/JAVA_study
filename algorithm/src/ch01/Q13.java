package ch01;

import java.util.Scanner;

public class Q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정사각형을 출력합니다.");
        System.out.print("한 변의 길이를 입력하세요: ");
        int n = sc.nextInt();

        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <=n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
