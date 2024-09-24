import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/*
문제 16 - 기능 개발
 */

public class Test16 {
    public static int[] solution(int[] progresses, int[] speeds) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i<progresses.length; i++) {
            queue.addLast(progresses[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        int endProcess;
        while(!queue.isEmpty()) {
            endProcess=0;
            while(queue.peekFirst() == 100) {
                queue.pollFirst();
                endProcess++;
                if(queue.isEmpty()) {
                    break;
                }
            }
            if(endProcess != 0 ) {
                list.add(endProcess);
            }
            int value;
            for(int i = 0; i<queue.size(); i++) {
                if(queue.isEmpty()) break;
                value = queue.pollFirst() + speeds[i];
                if(value > 100) {
                    value = 100;
                }
                queue.addLast(value);
            }
        }

        int[] result= new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            result[index] = i;
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};
        int[] result;

        result = solution(progresses,speeds);
        System.out.println(Arrays.toString(result));

        result = solution(new int[] {95,90,99,99,80,99}, new int[] {1,1,1,1,1,1});
        System.out.println(Arrays.toString(result));
    }
}
