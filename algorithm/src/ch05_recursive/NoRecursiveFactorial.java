package ch05_recursive;

import java.util.Scanner;

//Q1
public class NoRecursiveFactorial {
    public static int factorial(int n) {
        if(n == 0) {
            return 1;
        }
        int result = 1;

        while(true) {
            result *= n;
            n--;
            if(n==0) break;
        }

        return result;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        System.out.print("n : ");
        n = sc.nextInt();
        
        int result = factorial(n);
        System.out.println("result = " + result);
    }
}
