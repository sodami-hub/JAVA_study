package ch01;

// 정수 a,b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환하는 메서드를 작성하라.
public class Q8 {

    static int sumof(int a, int b) {
        int sum=0;

        int n = Math.abs(a-b);
        if(n==1) {
            return a+b;
        }

        if(n%2 == 1) {  // 두 수의 차가 홀수이면
            n=(n+1)/2;
            return (a+b)*n;
        } else {
            return ((a+b)/2) * (n+1);
        }
    }


    public static void main(String[] args) {
        int sum = sumof(1, 2);
        System.out.println(sum);
        sum = sumof(1, 3);
        System.out.println(sum);
        sum = sumof(1, 4);
        System.out.println(sum);
        sum = sumof(1, 5);
        System.out.println(sum);
    }
}
