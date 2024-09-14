/*
문제 03 - 두 개 뽑아서 더하기
정수 배열의 서로 다른 인덱스에 있는 2개의 수를 뽑아 더해서 만들 수 있는 모든 수의 배열에 오름차순으로 담아 반환하는 solution함수

*/

import java.util.*;

public class Test03 {

    public static int[] bookSol(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i<arr.length-1; i++) {
            for(int j = i+1; j<arr.length; j++) {
                hs.add(arr[i]+arr[j]);
            }
        }

        return hs.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static int[] solution(int[] arr) {
        TreeSet<Integer> ts = new TreeSet<>();

        for(int i = 0; i<arr.length-1; i++) {
            for(int j = i+1; j<arr.length; j++) {
                ts.add(arr[i]+arr[j]);
            }
        }

        int[] res = new int[ts.size()];
        int i= 0;
        for (int t : ts) {
            res[i++] = t;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,4,1};

        int[] res = solution(arr);
        System.out.println(Arrays.toString(res));

        int[] arr01 = {5,0,2,7};

        res = solution(arr01);
        System.out.println(Arrays.toString(res));
    }
}
