package ch06_sorting.shell_sort;

public class ShellSortV01 {
    public void shellSort(int[] a, int n) {
        int h = n;
        while (true) {
            h /= 2;
            for (int i = 0; i < n-h; i++) {
                for (int j = 0; j < n-h; j++) {
                    if(a[j]> a[j+h]) {
                        int tmp = a[j];
                        a[j] = a[j + h];
                        a[j + h] = tmp;
                    }
                }
            }
            if (h == 1) break;
        }

    }
}
