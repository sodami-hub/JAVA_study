package ch06_sorting.quick_sort;

import ch04_stack_queue.stack.IntStack;

public class QuickSort {
    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public void quickSortV01(int[] arr, int start, int end) {


        System.out.println("QuickSort Basic");

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

        System.out.println("Push { start: "+start+" right: "+end+" }");
        System.out.println("QuickSort Use Stack");

        lStack.push(start);
        rStack.push(end);

        int left;
        int right;

        while(lStack.isEmpty()==false) {
            left = start = lStack.pop();
            right = end = rStack.pop();
            System.out.print("Pop { start: arr["+start+"] ~ right: ["+end+"] } : ");
            for(int i=start; i<=end; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            int pivot = arr[(left+right)/2];

            do {
                while (arr[left] < pivot) {
                    left++;
                }

                while (arr[right] > pivot) {
                    right--;
                }

                if (left <= right) {
                    swap(arr, left++, right--);
                }
            } while (left <= right);

            if(start<right) {
                System.out.println("Push { start: "+start+" right: "+right+" }");
                lStack.push(start);
                rStack.push(right);
            }
            if(left<end) {
                System.out.println("Push { start: "+left+" right: "+end+" }");
                lStack.push(left);
                rStack.push(end);
            }
        }
    }
}

