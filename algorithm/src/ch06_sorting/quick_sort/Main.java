package ch06_sorting.quick_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {5,7,1,4,6,2,3,9,8};
        quickSort.quickSortV01(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {5,7,1,4,6,2,3,9,8};
        quickSort.quickSortUseStack(arr2, 0, arr2.length-1);
        System.out.println(Arrays.toString(arr2));
    }
}
