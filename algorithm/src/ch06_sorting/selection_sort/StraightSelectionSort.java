package ch06_sorting.selection_sort;

public class StraightSelectionSort {
    public void selectionSort(int[] arr, int len) {
        for(int i = 0; i < len-1; i++) {
            int minIndex = i;
            for(int j= i+1; j<len; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    //Q6 -- 단순 선택 정렬의 동작과정을 상세하게 보여주기.
    public void viewSelectionSort(int[] arr, int len) {
        for(int i = 0; i < len-1; i++) {
            int minIndex = i;

            for(int k=0; k<=i; k++) {
                if(k==i) {
                    System.out.print("  *");
                    break;
                }
                System.out.print("   ");
            }


            for(int j= i+1; j<len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            for(int k= i+1; k<=minIndex; k++) {
                if(k==minIndex) {
                    System.out.print("  +");
                    System.out.println();
                    break;
                }
                System.out.print("   ");
            }
            for(int num : arr) {
                System.out.printf("%3d",num);
            }
            System.out.println();
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
