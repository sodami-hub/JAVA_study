package ch06_sorting.insertion_sort;

// 단순 삽입 정렬
public class SimpleInsertionSort {

    public void simpleInsertionSort(int[] arr, int length) {
        int val;

        for(int i = 1 ; i <length ; i++) {
            val = arr[i];
            for(int j = i-1; j >= 0 && val < arr[j]; j--) {
                arr[j+1] = arr[j];
                arr[j] = val;
            }
        }


    }
}
