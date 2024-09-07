package ch06_sorting._08_counting_sort;

public class CountingSort {

    public void countingSort(int[] arr, int n) {
        // 0. 전달받은 배열의 최댓값 구하기.
        int max = 0;
        for(int num : arr) {
            if(num > max) {
                max = num;
            }
        }

        int[] f = new int[max+1];  // 누적 도수 분포를 저장할 배열
        int[] temp = new int[n];  // arr과 f를 통해서 정렬된 배열이 저장될

        // 1. 도수 분포표 만들기.
        for(int i = 0; i<n; i++) {
            f[arr[i]]++;
        }
        // 2. 누적 도수 분포표 만들기
        for(int i= 1; i<=max; i++) {
            f[i] += f[i-1];
        }
        // 3. 목표 배열 만들기
        for(int i=n-1; i>=0;i--) {
            temp[f[arr[i]]-1]=arr[i];
            f[arr[i]]--;
        }
        // 4. 배열 복사
        for(int i=0; i<n;i++){
            arr[i] = temp[i];
        }
    }
}
