
/*
문제05 - 행렬의 곱셈
*/

import java.util.Arrays;

public class Test05 {

    public static int[][] solution(int[][] arr01, int[][] arr02) {
        int x = arr01.length;
        int y = arr01[0].length;

        int[][] result = new int[x][y];
        int value = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        int num01 = 0;
        int num02 = 0;

        for (i = 0; i < x * y; i++) {
            value = 0;
            for (j = 0; j < y; j++) {
                num01 = arr01[i / y][j];
                for (k = j; k <= j; k++) {
                    num02 = arr02[k][i % y];
                    value += num01 * num02;
                }
            }
            result[i / y][i % y] = value;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr01 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr02 = {{3, 3}, {3, 3}};

        int[][] result = solution(arr01, arr02);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }

        int[][] arr03 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr04 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        result = solution(arr03, arr04);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
