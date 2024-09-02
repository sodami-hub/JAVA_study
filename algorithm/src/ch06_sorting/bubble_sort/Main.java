package ch06_sorting.bubble_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nversion 1 =======================================================\n");
        int[] arr1 = new int[] {1,3,9,4,7,8,6};
        BubbleSortSpecificV01.bubbleSort(arr1, arr1.length);


        System.out.println("\nversion 2 =======================================================\n");
        int[] arr2 = new int[] {1,3,9,4,7,8,6};
        BubbleSortSpecificV02.bubbleSort(arr2,arr2.length);

        System.out.println("\nversion 2 =======================================================\n");
        int[] arr3 = new int[] {1,3,9,4,7,8,6};
        BubbleSortV03.bubbleSortV03(arr3, arr3.length);
        System.out.println(Arrays.toString(arr3));
    }
}
