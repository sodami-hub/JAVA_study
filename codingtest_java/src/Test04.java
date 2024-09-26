import java.util.ArrayList;
import java.util.Arrays;

public class Test04 {

    public static int[] sol(int[] answer) {

        int[][] pat = {
                        {1,2,3,4,5},
                        {2,1,2,3,2,4,2,5},
                        {3,3,1,1,2,2,4,4,5,5}
                        };

        // 점수 구하기.
        ArrayList<Integer> scores = new ArrayList<>();
        for(int k =0; k< pat.length; k++) {
            int count =0;
            int score =0;
            for (int i = 0; i < answer.length; i++) {
                if(count >= pat[k].length) {
                    count = 0;
                }
                if(answer[i] == pat[k][count]) {
                    score++;
                }
                count++;
            }
            scores.add(score);
        }
        System.out.println("scores = " + scores);

        
        // 결과값에서 최대값 가져오기.
        int max = 0;
        for (Integer score : scores) {
            if(score > max) {
                max = score;
            }
        }

        // 최대값과 같은 값을 갖는 사람을 리스트에 추가.
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < scores.size(); i++) {
            if(scores.get(i) == max) {
                list.add(i+1);
            }
        }
        // 리스트를 배열로 반환
        return list.stream().mapToInt(i->i).toArray();
    }


    public static void main(String[] args) {
        int[] answer = {1,2,3,4,5};
        int[] result = sol(answer);
        System.out.println(Arrays.toString(result));

        int[] answer02 = {1,3,2,4,2};
        result = sol(answer02);
        System.out.println(Arrays.toString(result));
    }
}
