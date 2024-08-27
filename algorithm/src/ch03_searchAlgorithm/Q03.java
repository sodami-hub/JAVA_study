package ch03_searchAlgorithm;

import java.util.Arrays;

// 요솟수가 n인 배열 arr에서 key와 일치하는 모든 요소의 인덱스를 배열 idx의 맨 앞부터 순서대로 저장하고,
// 일치하는 요솟수를 반환하는 메서드를 작성하세요.
public class Q03 {
    static int searchIdx(int[] arr, int n, int key, int[] idx) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == key) {
                idx[count] = i;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,9,2,9,4,6,7,9};
        int n = arr.length;
        int[] idx = new int[n];
        int key = 9;

        int count = searchIdx(arr, n, key, idx);

        System.out.println("키 값과 같은 요소의 갯수는 : " +count);
        System.out.println("키 값과 같은 요소의 인덱스는 : " + Arrays.toString(Arrays.copyOfRange(idx, 0, count)));
    }
}
