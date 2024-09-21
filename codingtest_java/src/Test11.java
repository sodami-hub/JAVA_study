/*
문제 11 - 짝지어 제거하기
 */

public class Test11 {
    public static int solution(String pat) {
        StringBuilder str = new StringBuilder(pat);
        int i = 0;
        int j = 1;
        while(true) {
            if(str.length() <= 1 || j >= str.length()) break;
            if(str.charAt(i)==str.charAt(j)) {
                str.deleteCharAt(i);
                str.deleteCharAt(i);
                i = 0;
                j = 1;
                if(j == str.length()) break;
                continue;
            }
            i++;
            j++;
        }
        if(str.isEmpty()) {
            return 1;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int result;
        result = solution("baabaa");
        System.out.println("result = " + result);
        
        result = solution("cdcd");
        System.out.println("result = " + result);
    }
}
