package ch03_searchAlgorithm;

import java.util.Scanner;

//이진 검색 과정 자세히 표현
public class Q04 {

    public static void binarySearch(int[] arr, int start, int end, int key) {
        System.out.print("   |");
        for (int i = 0; i <= end; i++) {
            System.out.printf("%3d",i);
        }
        System.out.println();
        System.out.print("---+");
        for (int i = 0; i <= end; i++) {
            System.out.print("----");
        }
        System.out.println();
        int initStart = start;
        int initEnd = end;

        while(start <= end) {
            System.out.print("   |");
            int mid = (start + end) / 2;
            for(int i = initStart; i <= initEnd; i++) {
                if(i>=start && i<=end) {
                    if(start == end || start == mid || end == mid) {
                        System.out.print("  + ");
                        break;
                    }
                    if (i == start) {
                        System.out.print(" <- ");
                        continue;
                    }
                    if (i == mid) {
                        System.out.print(" + ");
                        continue;
                    }
                    if (i == end) {
                        System.out.print("->");
                        continue;
                    }
                }
                System.out.print("   ");
            }

            System.out.println();
            System.out.printf("%3d|", arr[mid]);
            for(int i = 0; i <= initEnd; i++) {
                System.out.printf("%3d",arr[i]);
            }
            if(arr[mid] == key) {
                System.out.println();
                System.out.println("찾는 값 "+key+"는 arr["+mid+"]에 있습니다.");
                break;
            }else if(arr[mid] < key) {
                start = mid + 1;
            }else if(arr[mid] > key) {
                end = mid - 1;
            }
            System.out.println();
            if(start >= end) {
                System.out.println("\n찾는 값이 없다.");
                break;
            }
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

        binarySearch(arr, 0, len-1, key);
    }
}
