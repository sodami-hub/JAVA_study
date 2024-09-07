package ch06_sorting.heap_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr= {6,4,3,7,1,9,8};
        HeapSort hs = new HeapSort();
        hs.makeHeap(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
