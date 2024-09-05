package ch06_sorting.quick_sort;

import ch04_stack_queue.stack.IntStack;

public class QuickSort {
    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public void insertionSort(int[] arr, int n) {
        for(int i = 1; i<n;i++) {
            int j;
            int value = arr[i];
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                    arr[j] = value;
                }
            }
        }
    }

    public void quickSortV01(int[] arr, int start, int end) {

        // Q13
        if(end-start <10) {
            System.out.println("요소수가 적어 삽입정렬 합니다.");
            insertionSort(arr, arr.length);
            return;
        }

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
        // Q13
        if(end-start <10) {
            System.out.println("요소수가 적어 삽입정렬 합니다.");
            insertionSort(arr, arr.length);
            return;
        }

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

            //Q11 요소가 적은 그룹을 먼저 실행되도록 나중에 push(stack은 LIFO)한다.
            int preFactor = right-start;
            int postFactor = end-left;

            if(postFactor<preFactor) {
                if (start < right) {
                    System.out.println("Push { start: " + start + " right: " + right + " }");
                    lStack.push(start);
                    rStack.push(right);
                }
                if (left < end) {
                    System.out.println("Push { start: " + left + " right: " + end + " }");
                    lStack.push(left);
                    rStack.push(end);
                }
            } else {
                if (left < end) {
                    System.out.println("Push { start: " + left + " right: " + end + " }");
                    lStack.push(left);
                    rStack.push(end);
                }
                if (start < right) {
                    System.out.println("Push { start: " + start + " right: " + right + " }");
                    lStack.push(start);
                    rStack.push(right);
                }
            }
        }
    }
}

