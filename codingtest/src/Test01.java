
/*
몸풀기 문제
문제 01 - 배열 정렬하기
*/

import java.util.Arrays;

public class Test01 {

    public static void  sortMethod(int[] arr) {
        Arrays.sort(arr);
    }

    public static void insertSort(int[] arr, int n) {

    }




    public static void main(String[] args) {
        int[] arr01 = {1,-5,2,4,3};
        int[] arr02 = {1,1,2,2,3,4,5};
        int[] arr03 = {6,1,7};

        sortMethod(arr01);
        System.out.println(Arrays.toString(arr01));
    }
}
