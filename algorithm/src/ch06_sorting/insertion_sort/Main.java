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

        //삽입 정렬 상세 동작
        int[] arr02 = {6,4,8,5,2,9,7};
        sis.viewInsertionSort(arr02, arr02.length);

    }
}
