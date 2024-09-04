package ch06_sorting.shell_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Shell Sort Version01
        int[] arr = {8, 1, 4, 2, 7, 6, 3};

        ShellSortV01 ss = new ShellSortV01();
        ss.shellSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
