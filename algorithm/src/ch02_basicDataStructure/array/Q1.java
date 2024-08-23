package ch02_basicDataStructure.array;

import java.util.Random;
import java.util.Scanner;

public class Q1 {
    public static int max(int[] a) {
        int max = a[0];
        for(int i = 1; i < a.length; i++) {
            if(max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int[] height = new int[rand.nextInt(50) + 1];

        for(int i = 0; i < height.length; i++) {
            height[i] = rand.nextInt(100) + 100;
        }

        System.out.println(height.length+"의 사람들 중 가장 큰 키의 값은 : "+ max(height) + "cm  입니다.");
    }
}
