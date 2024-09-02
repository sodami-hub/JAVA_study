package ch04_stack_queue;

public class Example04 {
    public static void main(String[] args) {
        int num1;
        int num2;

        while(true) {
            num1 = (int)(Math.random() * 6+1);
            num2 = (int)(Math.random() * 6+1);

            System.out.println("("+num1+","+num2+")");

            if(num1+num2 == 5) break;
        }

    }
}
