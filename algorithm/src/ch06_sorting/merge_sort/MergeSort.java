package ch06_sorting.merge_sort;

public class MergeSort {
    static int[] buff = new int[10];

    public void mergesort(int[] a, int left, int right) {
        if(left<right) {
            int center = (left+right)/2;
            int i;
            int j=0;
            int k=left;
            int p=0;

            mergesort(a, left, center);
            mergesort(a, center+1, right);

            for(i = left; i<=center; i++) {
                buff[p++] = a[i];               // 앞쪽 요소를 작업용 배열에 넣는다. i=1, p=1, r=1,k=0, j=0
            }

            while(i<=right && j<p) {
                a[k++] = (buff[j]<=a[i])?buff[j++]:a[i++];
            }

            while(j<p) {
                a[k++] = buff[j++];
            }
        }
    }
}
