/*
01. 배열 정렬하기
*/


import java.util.Arrays;

public class Test01 {

    public static void sortMethod(int[] arr) {
        Arrays.sort(arr);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {  // 반복할 때마다 제일 큰 숫자가 뒤로 감.(맨 뒤쪽을 하나씩 줄임)
                if(arr[j]> arr[j+1]) {
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void selectSort(int[] arr, int n) {
        for(int i = 0; i<n; i++) {
            int min =i;
            for(int j=i+1; j < n; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    public static void insertSort(int[] arr, int n) {
        for(int i = 1; i<n; i++) {
            int idx=-1;
            int value = arr[i];
            for(int j = i-1; j>=0; j--) {
                if(arr[j]>value) {
                    arr[j+1] = arr[j];
                    idx = j;
                }
            }
            if(idx != -1) {
                arr[idx] = value;
            }
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        int pivot = (left+right)/2;
        int pl = left;
        int pr = right;

        while(pl <= pr) {

            while(arr[pl] < arr[pivot]) {
                pl++;
            }

            while(arr[pr] > arr[pivot]) {
                pr--;
            }

            if(pl <= pr) {
                swap(arr,pr--,pl++);
            }

        }

        if(left < pr) {
            quickSort(arr, left, pr);
        }
        if(right > pl) {
            quickSort(arr, pl, right);
        }

    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 1, 7, 4, 8, 12, 11, 32, 10, 3};
        System.out.println(Arrays.toString(arr));

        System.out.println("===== Arrays.sort() 사용 ========");
        int[] copyArr = arr.clone();
        sortMethod(copyArr);
        System.out.println(Arrays.toString(copyArr));

        System.out.println("\n===== 버블 정렬 사용 ========");
        copyArr = arr.clone();
        bubbleSort(copyArr, copyArr.length);
        System.out.println(Arrays.toString(copyArr));

        System.out.println("\n===== 선택 정렬 사용 ========");
        copyArr = arr.clone();
        selectSort(copyArr, copyArr.length);
        System.out.println(Arrays.toString(copyArr));

        System.out.println("\n===== 삽입 정렬 사용 ========");
        copyArr = arr.clone();
        insertSort(copyArr, copyArr.length);
        System.out.println(Arrays.toString(copyArr));

        System.out.println("\n==== 퀵 정렬 사용 ========");
        copyArr = arr.clone();
        quickSort(copyArr, 0, copyArr.length-1);
        System.out.println(Arrays.toString(copyArr));
    }

}
