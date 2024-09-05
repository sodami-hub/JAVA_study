package ch06_sorting.quick_sort;

import ch04_stack_queue.stack.IntStack;

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

    public void quickSortUseStack(int[] arr, int start, int end) {
        IntStack lStack = new IntStack(end-start+1);
        IntStack rStack = new IntStack(end-start+1);

        lStack.push(start);
        rStack.push(end);

        int left;
        int right;

        while(lStack.isEmpty()==false) {
            left = start = lStack.pop();
            right = end = rStack.pop();

            int pivot = arr[(left+right)/2];

            while(arr[left]<pivot) {
                left++;
            }

            while(arr[right]>pivot) {
                right--;
            }

            if(left<=right) {
                swap(arr, left++, right--);
            }

            if(start<right) {
                lStack.push(start);
                rStack.push(right);
            }
            if(left<end) {
                lStack.push(left);
                rStack.push(end);
            }
        }
    }

}

