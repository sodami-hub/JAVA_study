package ch02_basicDataStructure.array;

import java.util.Arrays;

public class Q2_Q5 {

    // swap method
    public static void swap(int[] arr, int idx1, int idx2) {
        int temp;
        temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    //Q2
    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            System.out.println(Arrays.toString(arr));
            System.out.println("arr["+i+"]와 "+"arr["+(arr.length-i-1)+"]을 교환합니다.");

            swap(arr, i, arr.length-i-1);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("연순 정렬이 끝났습니다.");
    }

    //Q3
    public static int sumOf(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    //Q4
    public static void copy(int[] src, int[] dest) {
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
    }

    public static void rcopy(int[] src, int[] dest) {
        for (int i = src.length-1; i >= 0 ; i--) {
            dest[src.length-i-1] = src[i];
        }
    }

    public static void main(String[] args) {

        //Q2
        int[] arr = new int[] {2,5,1,3,9,6,7};
        System.out.println("====== Q2 ======");
        reverse(arr);

        //Q3
        System.out.println("====== Q3 ======");
        System.out.println("배열 " + Arrays.toString(arr) + "의 요소의 총 합은" + sumOf(arr));

        System.out.println("====== Q4 ======");
        int[] copyArr = new int[arr.length];
        System.out.println("복사 전 배열의 요소 :"+Arrays.toString(copyArr));
        copy(arr, copyArr);
        System.out.println("복사 후 배열의 요소 :"+Arrays.toString(copyArr));

        System.out.println("====== Q5 ======");
        int[] rCopyArr = new int[arr.length];
        System.out.println("복사 할 배열의 요소 :"+Arrays.toString(arr));
        rcopy(arr, rCopyArr);
        System.out.println("복사 된 배열의 요소 :"+Arrays.toString(rCopyArr));
    }
}
