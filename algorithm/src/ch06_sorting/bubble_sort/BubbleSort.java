package ch06_sorting.bubble_sort;

import java.util.Arrays;

public class BubbleSort {
    private int[] arr;

    public BubbleSort(int[] array) {
        this.arr = array;
    }

    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void bubbleSort() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0 ; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    this.swap(j, j + 1);
                }
            }
        }
    }

    public void printArray() {
        System.out.println(Arrays.toString(arr));

    }
}
