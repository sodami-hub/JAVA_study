package ch06_sorting.insertion_sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //단순 삽입 정렬
        int[] arr01 = {6,4,3,7,1,9,8};
        SimpleInsertionSort sis = new SimpleInsertionSort();
        sis.simpleInsertionSort(arr01, arr01.length);
        System.out.println("simple insert sort : "  + Arrays.toString(arr01));
    }
}
