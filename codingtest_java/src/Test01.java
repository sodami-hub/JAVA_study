/*
01. 배열 정렬하기
*/


import java.util.Arrays;

public class Test01 {

    public static void sortMethod(int[] arr) {
        Arrays.sort(arr);
    }

    public static void insertSort(int[] arr ,int n) {

    }
    
    public static void main(String[] args) {
        int[] arr = {4,2,6,1,7,4,8,12,11,32,10,3};
        
        int[] copyArr = arr.clone();
        sortMethod(copyArr);
        System.out.println(Arrays.toString(copyArr));
    }
    
}
