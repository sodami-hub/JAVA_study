
/*
문제05 - 행렬의 곱셈
*/

import java.util.Arrays;

public class Test05 {

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int x = arr1.length;
        int y = arr1[0].length;

        int[][] result = new int[x][y];
        int value;
        int num01;
        int num02;

        for (int i = 0; i < x * y; i++) {
            value = 0;
            for (int j = 0; j < y; j++) {
                num01 = arr1[i / y][j];
                for (int k = j; k <= j; k++) {
                    num02 = arr2[k][i % y];
                    value += num01 * num02;
                }
            }
            result[i / y][i % y] = value;
        }

        return result;
    }

    public static int[][] solution02(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr1[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i<row; i++) {  // 행 고정
            for(int j = 0; j<col; j++) {  // 열 고정
                for(int k = 0; k<arr2.length; k++) { // 스캔
                    result[i][j] += arr1[i][k] * arr2[k][j]; // arr01의 행을 고정하고 스캔, arr02의 열을 고정하고 스캔
                }
            }
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

        System.out.println("\n==== second sol");
        result = solution02(arr03,arr04);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));

        }
    }
}
