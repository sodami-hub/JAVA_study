package ch06_sorting.bubble_sort;

import java.util.Arrays;

//양방향 버블 소트 // shaker sort or cocktail sort
//홀수 번째 패스는 작은 요소를 앞으로(뒤에서 앞으로)
//짝수 번째 패스는 큰 요소를 뒤로(앞에서 뒤로)
// => 암튼 이런식으로 만들어봄
public class ShakerSort {
    public static void shakerSort(int[] arr, int n) {
        int start = 0;
        int end = n-1;

        int left = 0;
        int right = n-1;

        int count = 0;

        while(left < right) {
            System.out.println("패스 : " + (count+1));
            for(int i = left; i <end; i++) {
                if(arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                    right = i;
                }
            }

            count++;
            System.out.println("패스 : " + (count+1));
            for(int i = right; i > start; i--) {
                if(arr[i] < arr[i-1]) {
                    swap(arr, i, i-1);
                    left = i;
                }
            }
            count++;
        }


        /*
        for (int i = start; i < end-1; i++) {
            System.out.println("패스 : " + (i+1));
            exchange = 0;
            if(i%2==1) {
                for(int j = end-1; j >start; j--) {
                    if(arr[j]<arr[j-1]) {
                        swap(arr, j, j-1);
                        exchange++;
                    }
                }
            } else {
                for(int j = start; j < end-1; j++) {
                    if(arr[j]>arr[j+1]) {
                        swap(arr, j, j+1);
                        exchange++;
                    }
                }
            }

            System.out.println(Arrays.toString(arr));
            if(exchange==0) {break;}
        }
        */
    }


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
