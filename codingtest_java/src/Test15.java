import java.util.ArrayDeque;

/*
문제 15 - 요세푸스 문제
 */

public class Test15 {
    public static int solution(int n, int k) {
        ArrayDeque<Integer> queue01 = new ArrayDeque<>(5);

        for(int i = 0; i<n;i++) {
            queue01.addLast(i+1);
        }
        int value=-1;
        int delValue=-1;
        while(!queue01.isEmpty()) {
            for(int j =1;j<k;j++) {
                value=queue01.pollFirst();
                queue01.addLast(value);
            }
            delValue= queue01.pollFirst();
        }
        if(value == -1 ){
            return delValue;
        } else {
            return value;
        }
    }

    public static void main(String[] args) {
        int result;
        
        result= solution(5,1);
        System.out.println("result = " + result);
    }
}
