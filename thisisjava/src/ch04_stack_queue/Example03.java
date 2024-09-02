package ch04_stack_queue;

public class Example03 {
    public static void main(String[] args) {
        int sum=0;

        for(int i = 1; i<=100; i++) {
            if(i%3 == 0) {
                sum += i;
            }
        }

        System.out.println("1~100까지의 수 중에서 3의 배수의 합은 ="+sum);
    }
}
