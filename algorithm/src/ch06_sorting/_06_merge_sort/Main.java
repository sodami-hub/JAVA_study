package ch06_sorting._06_merge_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {6,4,3,7,1,9,8};
        MergeSort ms = new MergeSort();
        ms.mergesort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
