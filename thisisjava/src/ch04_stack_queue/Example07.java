package ch04_stack_queue;

import java.util.Scanner;

public class Example07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int choiceNum;
        int balance=0;

        while(true) {
            System.out.println("-------------------------------------");
            System.out.println("1: 예금 | 2. 출금 | 3.잔고 | 4.종료");
            System.out.println("-------------------------------------");

            System.out.print("선택> ");

            choiceNum = input.nextInt();

            switch(choiceNum) {
                case 1:
                    System.out.print("예금액> ");
                    balance += input.nextInt();
                    break;
                case 2:
                    System.out.print("출금액> ");
                    balance -= input.nextInt();
                    break;
                case 3:
                    System.out.println("잔고> "+balance);
                    break;
            }

            if(choiceNum == 4) {
                System.out.println("프로그램 종료");
                break;
            }
        }

        input.close();
    }
}
