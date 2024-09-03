package ch06_sorting.selection_sort;

public class StraightSelectionSort {
    public void selectionSort(int[] arr, int len) {
        for(int i = 0; i < len-1; i++) {
            int minIndex = i;
            for(int j= i+1; j<len; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
