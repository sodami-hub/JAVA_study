package ch06_sorting._04_shell_sort;

import static java.lang.System.currentTimeMillis;

public class ShellSort {

    // Shell Sort version01
    public void shellSortV01(int[] a, int n) {
        long start = currentTimeMillis();
        int h = n;
        int count=0;
        while (true) {
            h /= 2;
            System.out.println("h : "+h);
            for (int i = 0; i < n-h; i++) {
                for (int j = 0; j < n-h; j++) {
                    if(a[j]> a[j+h]) {
                        int tmp = a[j];
                        a[j] = a[j + h];
                        a[j + h] = tmp;
                        count++;
                    }
                }
            }
            if (h == 1) break;
        }
        System.out.println("v01 소요시간 : "+(currentTimeMillis()-start));
        System.out.println("교환 횟수 :" + count);
    }

    // Shell Sort version02
    public void shellSortV02(int[] a, int n) {
        long start = currentTimeMillis();
        int h=0;
        int count=0;
        for(int i=1;i<n;i=i*3+1){
            h=i;
        }

        for(; h>=1; h/=3) {
            System.out.println("h : "+h);
            for(int i =0; i<n-h; i++) {
                for(int j=0; j<n-h; j++) {
                    if(a[j]> a[j+h]) {
                        int tmp = a[j];
                        a[j] = a[j + h];
                        a[j + h] = tmp;
                        count++;
                    }
                }
            }
        }
        System.out.println("v02 소요시간 : "+(currentTimeMillis()-start));
        System.out.println("교환 횟수 :" + count);
    }

}
