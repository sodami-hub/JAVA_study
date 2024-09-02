package ch06_sorting.bubble_sort;

import java.util.Arrays;

// 각 정렬 버전별 반복 및 비교횟수 비교.
public class Main {
    public static void main(String[] args) {
        System.out.println("\nversion 1 =======================================================\n");
        int[] arr1 = new int[] {1,3,9,4,7,8,6,54,246,12566,323,34,2667,2,4667,2,89,56734,25656,132,1,4686};
        BubbleSortSpecificV01.bubbleSort(arr1, arr1.length);


        System.out.println("\nversion 2 =======================================================\n");
        int[] arr2 = new int[] {1,3,9,4,7,8,6,54,246,12566,323,34,2667,2,4667,2,89,56734,25656,132,1,4686};
        BubbleSortSpecificV02.bubbleSort(arr2,arr2.length);

        System.out.println("\nversion 3 =======================================================\n");
        int[] arr3 = new int[] {1,3,9,4,7,8,6,54,246,12566,323,34,2667,2,4667,2,89,56734,25656,132,1,4686};
        BubbleSortV03.bubbleSortV03(arr3, arr3.length);
        System.out.println(Arrays.toString(arr3));


        System.out.println("\nshaker sort =======================================================\n");
        int[] arr4 = {1,3,9,4,7,8,6,54,246,12566,323,34,2667,2,4667,2,89,56734,25656,132,1,4686};
        ShakerSort.shakerSort(arr4,arr4.length);
        System.out.println(Arrays.toString(arr4));
    }
}
