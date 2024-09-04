package ch06_sorting.shell_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Shell Sort Version01
        int[] arr = {4756,241,5677,231,54,1668,1457,34,82,2,66,898956,134656,2345,4,23,65,1,7,3,1,43,98,6,66789,1,578,1234,4787,125,6,23,8000,54784,1247798,24,667};

        ShellSort ss = new ShellSort();
        ss.shellSortV01(arr, arr.length);
        System.out.println(Arrays.toString(arr));

        //Shell Sort Version02
        int[] arr02 = {4756,241,5677,231,54,1668,1457,34,82,2,66,898956,134656,2345,4,23,65,1,7,3,1,43,98,6,66789,1,578,1234,4787,125,6,23,8000,54784,1247798,24,667};
        ss.shellSortV02(arr02,arr02.length);
        System.out.println(Arrays.toString(arr02));
    }
}
