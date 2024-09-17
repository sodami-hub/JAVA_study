/*

문제 6 - 실패율
전체 스테이지 개수 n, 게임을 이용하는 사용자가 현재 멈춰 있는 스테이지의 번호가 담긴 배열 stages
이때 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 반환하는 함수 완성

풀이 .. 각 스테이지별로 멈춰있는 인원이 담긴 배열 stopNum을 만들고 - 인덱스 번호가 스테이지번호 값이 멈춰있는 인원 -
stopNum 배열을 통해서 실패율을 구해서 정답 배열에 넣는다.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Test06 {
    public static int[] solution(int n, int[] stages) {

        // 1. 전체 스테이지의 크기로 각각의 스테이지의 실패율을 저장할 ArrayList를 초기화
        ArrayList<Double> fail = new ArrayList<>();
        for(double i = 0; i < n; i++) {
            fail.add(i);
        }

        // 2. 각 스테이지를 클리어하지 못하고 있는 인원을 stopNum에 저장. -
        // 실패율을 구하려는 스테이지 범위를 넘어서는 회원의 수는 outMember에 저장하고 실패율의 분모값의 기본값으로 넣어줌
        int[] stopNum = new int[n];
        int outMember = 0;
        for(int i = 0; i < stages.length; i++) {
            if(stages[i] <= n) {
                stopNum[stages[i]-1]++;  // stages의 각 인덱스의 요소값(멈춘 스테이지)의 -1 값으로 stopNum배열에 저장
            } else {
                outMember++;
            }
        }

        // 3. 실패율 구하기
        int boonMo = outMember;  // 실패율의 분자와 분모를 정의 각 스테이지를 클리어한 전체 인원
        for(int i = stopNum.length-1; i>=0; i--) {  // 마지막 스테이지부터 더하면서 분모값을 설정하고
            boonMo += stopNum[i];  // 각 스테이지를 거친 회원들의 총 수
            fail.set(i, stopNum[i] / (double)boonMo); // 각 스테이지의 실패율 = 현재 클리어하지 못한 회원수 / 현 스테이지를 클리어했거나 아직 클리어하지 못한 전체 인원
        }

        // 최종 결과값을 저장할 배열 생성
        int[] result = new int[fail.size()];

        double max = -1;
        int stage=0;

        for(int i = 0; i < result.length; i++) {
            max = -1;
            for (int j = 0; j < fail.size(); j++) {
                if (fail.get(j) > max && fail.get(j) != -1) {
                    max = fail.get(j);
                    stage = j;
                }
            }
            result[i] = stage+1;  // 실패율의 최대값의 인덱스의 +1 값(스테이지)를 결과 배열에 순서대로 저장
            fail.set(stage,-1.0); // 결과값에 저장된 인덱스의 값은 -1로 값을 변경
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,2,6,2,4,3,3};
        int[] result = solution(5, arr);
        System.out.println(Arrays.toString(result));

        System.out.println();
        int[] arr01  = {4,4,4,4,4};
        int[] result01 = solution(4, arr01);
        System.out.println(Arrays.toString(result01));
    }
}
