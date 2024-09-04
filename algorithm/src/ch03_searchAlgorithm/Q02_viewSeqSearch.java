package ch03_searchAlgorithm;

import java.util.Scanner;

// 선형 검색의 스캐닝 과정을 자세히 보여주기.
public class Q02_viewSeqSearch {
    public static void viewSeqSearch(int[] arr, int len, int key) {
        System.out.print("   |");
        for (int i = 0; i < len; i++) {
            System.out.printf("%3d",i);
        }
        System.out.println();
        System.out.print("---+");
        for (int i = 0; i < len; i++) {
            System.out.print("----");
        }

        System.out.println();

        int count = 0;
        int index = -1;

        while(count < len) {
            System.out.print("   |");
            for (int i = 0; i <= count; i++) {
                if (i == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print("   ");
                }
            }

            System.out.print("*");
            System.out.println();
            System.out.printf("%3d|",count);

            for(int i=0; i<len; i++) {
                System.out.printf("%3d",arr[i]);
            }

            if(arr[count] == key) {
                index = count;
                System.out.println();
                break;
            }
            System.out.println();
            count++;
        }

        if(count >= len) {
            System.out.println("찾는 값이 없다.");
        }else {
            System.out.println("찾는 값은 arr["+index+"]에 있다.");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요소의 수 > ");
        int len = sc.nextInt();

        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            System.out.print("arr["+i+"] 값 > ");
            arr[i] = sc.nextInt();
        }

        System.out.print("찾을 값 > ");
        int key = sc.nextInt();

        viewSeqSearch(arr, arr.length, key);

    }

}
