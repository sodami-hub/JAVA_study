package ch01;

import java.util.Scanner;

public class Q9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1, num2;

        System.out.print("Enter number1: ");
        num1 = sc.nextInt();
        do {
            System.out.print("Enter number2: ");
            num2 = sc.nextInt();

            if (num2 < num1) {
                System.out.println("number2가 number1보다 커야 된다.");
            }
        } while (num2 < num1);

        System.out.println("number2 - number1 =" + (num2 - num1));
    }
}
