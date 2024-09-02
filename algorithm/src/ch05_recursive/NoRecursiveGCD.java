package ch05_recursive;

public class NoRecursiveGCD {
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        int tmp;

        while(true) {
            tmp = a;
            a=b;
            b=tmp%b;
            if(b == 0) return a;
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(22, 8));
    }
}
