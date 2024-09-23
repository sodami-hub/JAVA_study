/*
문제 12 - 주식 가격
 */


import java.util.Arrays;
import java.util.Stack;

public class Test12 {
    public static int[] solution(int[] pricePerSec) {
        int[] result = new int[pricePerSec.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int value;

        for(int i = 1; i<pricePerSec.length; i++) {
            value = -1;
            while(pricePerSec[stack.peek()] > pricePerSec[i]) {
                value = stack.pop();
                result[value] = i-value;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            value = stack.pop();
            result[value] = pricePerSec.length-1-value;
        }

        return result;
    }


    public static void main(String[] args) {

        int[] price = {1,2,3,2,3};
        int[] result = solution(price);
        System.out.println(Arrays.toString(result));
    }
}
