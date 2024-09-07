package ch06_sorting._07_heap_sort;

public class HeapSort {
    public void swap(int[] arr, int idx01, int idx02) {
        int temp = arr[idx01];
        arr[idx01] = arr[idx02];
        arr[idx02] = temp;
    }

    public void __makeHeap(int[] arr, int start, int end) {
        int parent;
        int child;
        int temp = arr[start];

        //  ==== 1. 배열을 힙으로 변환
        for(parent = start; parent < (end+1)/2 ; parent=child) {
            int cl = parent*2+1;
            int cr = cl+1;

            child = (end>=cr && arr[cl]<=arr[cr] )?cr:cl;
            if(arr[parent] >= arr[child]) {
                break;
            }
            swap(arr,parent,child);
        }
    }

    public void makeHeap(int[] arr, int start, int n){
        // ====== 1. 배열을 힙으로 변환
        for(int i = (n-1)/2; i>=0; i--) {
            __makeHeap(arr, i, n-1);
        }

        // ====== 2. 힙을 사용한 정렬. 오름차순
        for(int i = n-1; i>0; i--) {
            swap(arr, 0, i);
            __makeHeap(arr, 0, i-1);
        }
    }
}
