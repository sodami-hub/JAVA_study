package ch06_sorting.bubble_sort;

import java.util.Arrays;

public class BubbleSortSpecificV02 {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr, int n) {
        int compare = 0;
        int swapNum = 0;
        int change;

        for (int i = 0; i < n - 1; i++) {
            System.out.println("패스 : "+ (i+1));
            change = 0;
            System.out.println("버블정렬 ver02 - 상세 보이기");
            for (int j = 0 ; j < n - i - 1; j++) {
                compare++;
                for(int k = 0; k <= j-1 ; k++) {
                    System.out.print(arr[k]+" ");
                }
                if (arr[j] > arr[j + 1]) {
                    swapNum++;
                    System.out.print(arr[j]+" + "+arr[j+1]+" ");
                    swap(arr, j, j + 1);
                    change++;
                } else {
                    System.out.print(arr[j]+" - "+arr[j+1]+" ");
                }
                for(int k = j+2; k<arr.length ; k++) {
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println(Arrays.toString(arr));
            System.out.println();
            if(change == 0) {
                break;
            }
        }
        System.out.println("비교를 " + compare +"회 했습니다.");
        System.out.println("교환을 " + swapNum +"회 했습니다.");
    }
}
