package ch06_sorting.selection_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //단순선택정렬
        int[] arr = {6,4,8,3,1,9,7};
        StraightSelectionSort sss = new StraightSelectionSort();
        sss.selectionSort(arr,arr.length);
        System.out.println("arr = " + Arrays.toString(arr));


        System.out.println("\n===============================");
        //단순선택정렬 상세 보여주기 Q6 sol
        int[] arr01 = {6,4,8,3,1,9,7};
        sss.viewSelectionSort(arr01,arr01.length);
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
