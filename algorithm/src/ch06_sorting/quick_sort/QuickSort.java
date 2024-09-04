package ch06_sorting.quick_sort;

public class QuickSort {
    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public void quickSortV01(int[] arr, int start, int end) {
        int pivot = arr[(start+end)/2];
        int left = start;
        int right = end;
        while(left<=right) {
            while(arr[left]<pivot) {
                left++;
            }
            while(arr[right]>pivot) {
                right--;
            }
            if(left<=right) {
                swap(arr, left++, right--);
            }
        }
        if(start<right) {
            quickSortV01(arr, start, right);
        }
        if(left<end) {
            quickSortV01(arr, left, end);
        }
    }

}

