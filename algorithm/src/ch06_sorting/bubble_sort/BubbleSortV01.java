package ch06_sorting.bubble_sort;


// bubble sort 배열의 앞에서부터 정렬을 시작함. version01

public class BubbleSortV01 {

    static void bubbleSortV01(int[] arr, int n) {
        for(int i = 0; i < n-1; i++) {
            for(int j = n-1; j > i; j++) {
                if(arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                }
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
