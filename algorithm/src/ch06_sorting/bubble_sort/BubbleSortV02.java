package ch06_sorting.bubble_sort;

public class BubbleSortV02 {

    static void bubbleSortV02(int[] arr, int n) {
        int exChange;

        for(int i = 0; i < n-1; i++) {
            exChange = 0;
            for(int j = n-1; j > i; j++) {
                if(arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                    exChange++;
                }
            }
            if(exChange == 0) {
                break;
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
