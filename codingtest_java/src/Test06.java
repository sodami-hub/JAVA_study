/*

문제 6 - 실패율
전체 스테이지 개수 n, 게임을 이용하는 사용자가 현재 멈춰 있는 스테이지의 번호가 담긴 배열 stages
이때 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 반환하는 함수 완성

풀이 .. 각 스테이지별로 멈춰있는 인원이 담긴 배열 stopNum을 만들고 - 인덱스 번호가 스테이지번호 값이 멈춰있는 인원 -
stopNum 배열을 통해서 실패율을 구해서 정답 배열에 넣는다.
*/


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Test06 {
    public static double[] solution(int n, int[] stages) {
        double[] fail = new double[n];
        int[] stopNum = new int[n];
        int outMember = 0;
        for(int i = 0; i < stages.length; i++) {
            if(stages[i] < n) {
                stopNum[--stages[i]]++;
            } else {
                outMember++;
            }
        }

        System.out.println(Arrays.toString(stopNum));

        // 실패율의 분자와 분모를 정의
        int boonMo = outMember;
        for(int i = stopNum.length-1; i>=0; i--) {
            boonMo += stopNum[i];
            fail[i] = stopNum[i] / (double)boonMo;        // 각 스테이지의 실패율
            if(Double.isNaN(fail[i])) {
                fail[i] = 0;
            }
        }

        int[] result = new int[n];

        HashMap<Integer,Double> hm = new HashMap<>();
        for(int i = 0; i < n; i++) {
            hm.put(i+1,fail[i]);
        }



        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,2,6,2,4,3,3};
        double[] result = solution(5, arr);
        System.out.println(Arrays.toString(result));
    }
}
