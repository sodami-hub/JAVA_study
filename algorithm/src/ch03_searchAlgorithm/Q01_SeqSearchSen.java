package ch03_searchAlgorithm;

import java.util.Arrays;
import java.util.Scanner;


// 보초법(sentinel method)을 사용한 선형 검색
public class Q01_SeqSearchSen {

    public static int seqSearchSen(int[] arr, int n, int key) {
        int index =-1;
        for(int i=0; i<n; i++) {
            if(arr[i] == key) {
                index = i;
                break;
            }
        }

        if(index == n-1) {
            return -1;
        }else {
            return index;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수 : ");
        int n = sc.nextInt();

        int[] arr = new int[n+1];

        for (int i = 0; i < n; i++) {
            System.out.print("arr["+i+"] :");
            arr[i] = sc.nextInt();
        }

        System.out.print("찾는 값 : ");
        int key = sc.nextInt();
        arr[n] = key;

        int index = seqSearchSen(arr, arr.length, key);

        if(index == -1) {
            System.out.println("찾는 값이 없다.");
        } else {
            System.out.println("찾는 값은 arr["+index+"]에 있다.");
        }
    }
}
