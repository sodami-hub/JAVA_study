package ch05_recursive;

import ch04_stack_queue.stack.IntStack;

// 재귀는 Q6 부터... 못하겠다... 아 시불

public class Q6 {
    static void re(int n) {
        if(n>0) {
            re(n - 1);
            re(n - 2);
            System.out.print(n + " ");
        }
    }

    static void recur3(int n) {


    }

    public static void main(String[] args) {
        recur3(4);
        re(4); // 1,2,1,3,1,2,4;
    }
}
