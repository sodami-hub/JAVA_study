package ch06_sorting._05_quick_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        System.out.println("======== Quick Sort(with recursive)========");
        int[] arr = {5,7,1,4,6,2,9,8};
        quickSort.quickSortV01(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        System.out.println("\n======== Quick Sort(with stack)========");
        int[] arr2 = {5,8,4,2,6,1,3,9,7,63,12,352};
        quickSort.quickSortUseStack(arr2, 0, arr2.length-1);
        System.out.println(Arrays.toString(arr2));
    }
}
