package ch06_sorting.bubble_sort;

import java.util.Arrays;

public class BubbleSortSpecific {
    private int[] arr;

    public BubbleSortSpecific(int[] array) {
        this.arr = array;
    }

    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void bubbleSort() {
        int compare = 0;
        int swapNum = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("패스 : "+ (i+1));
            for (int j = 0 ; j < arr.length - i - 1; j++) {
                compare++;
                for(int k = 0; k <= j-1 ; k++) {
                    System.out.print(arr[k]+" ");
                }
                if (arr[j] > arr[j + 1]) {
                    swapNum++;
                    System.out.print(arr[j]+" + "+arr[j+1]+" ");
                    this.swap(j, j + 1);
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
        }
        System.out.println("비교를 " + compare +"회 했습니다.");
        System.out.println("교환을 " + swapNum +"회 했습니다.");
    }

    public void printArray() {
        System.out.println(Arrays.toString(arr));

    }
}
