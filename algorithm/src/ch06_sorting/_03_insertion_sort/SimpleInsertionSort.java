package ch06_sorting._03_insertion_sort;

// 단순 삽입 정렬
public class SimpleInsertionSort {

    // 단순 삽입정렬.
    public void simpleInsertionSort(int[] arr, int length) {
        int val;

        for(int i = 1 ; i <length ; i++) {
            val = arr[i];
            for(int j = i-1; j >= 0 && val < arr[j]; j--) {
                arr[j+1] = arr[j];
                arr[j] = val;
            }
        }
    }

    // 단순 삽입 정렬 동작 상세 보기.
    public void viewInsertionSort(int[] arr, int length) {
        int chPoint;
        boolean ch;
        for(int i = 1 ; i <length ; i++) {
            int val = arr[i];
            chPoint=0;
            ch =false;
            for(int n : arr) {
                System.out.printf("%3d",n);
            }
            System.out.println();
            for(int j = i-1; j >= 0  && val < arr[j] ; j--) {
                arr[j+1] = arr[j];
                arr[j]=val;
                chPoint=j;
                ch=true;
            }
            if(ch) {
                for (int k = 0; k < length; k++) {
                    if (k < chPoint) System.out.print("   ");
                    else if (k == chPoint) System.out.print("  ^");
                    else if (k < i) System.out.print("---");
                    else if (k == i) System.out.print("--+");
                }
            } else {
                for (int k = 0; k <= i; k++) {
                    if (k == i) System.out.print("  +");
                    else System.out.print("   ");

                }
            }
            System.out.println();
        }
    }
}
