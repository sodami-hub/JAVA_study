/*
문제 09 - 10진수를 2진수로 변환하기.
 */

import java.util.Stack;

public class Test09 {
    public static int solution(int decimal) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder binary= new StringBuilder();
        int value = decimal;
        
        while(true) {
            stack.push(value%2);
            value /=2;
            if(value==1){
                stack.push(value);
                break;
            }
        }
        
        while(!stack.isEmpty()) {
            value = stack.pop();
            binary.append(value);
        }
        String str = binary.toString();
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        int result;
        result = solution(123);
        System.out.println("result = " + result);
    }
}
