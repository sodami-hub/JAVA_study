
/*
문제 08 - 올바른 괄호
문자열의 괄호가 올바로 짝지어져있다면 true, 아니면 false를 반환하는 solution()을 작성하라.

풀이..
추출한 문자가 '(' 이면 스택에 푸쉬.
추출한 문자가 ')' 이면 팝
추출한 문자가 ')' 인데 스택이 비어있으면 false.

 */

import java.util.Stack;

public class Test08 {
    public static boolean solution(String pat) {
        Stack<Character> stack = new Stack<Character>();
        char ch;
        for(int i = 0; i<pat.length(); i++) {
            ch = pat.charAt(i);
            switch(ch) {
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    if(stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                    break;
            }
        }
        if(stack.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean result = solution("()()");
        System.out.println("result = " + result);

        System.out.println();
        result = solution("(())((())())");
        System.out.println("result = " + result);
        
        result = solution("()()(()))()");
        System.out.println("result = " + result);
    }
}
