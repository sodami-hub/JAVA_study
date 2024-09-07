package ch06_sorting._08_counting_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {22,5,11,32,120,68,70};
        CountingSort cs = new CountingSort();
        cs.countingSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
