package ch02_basicDataStructure.array;

import java.util.Arrays;
import java.util.Scanner;

// 기수 변환 과정을 자세히 나타내는 프로그램
public class Q6 {

    public static int cardConv(char[] res, int originNum, int cardinalNum) {
        String tmp = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int index = 0;
        int preOrigin=0;
        char t;
        do {
            System.out.printf("%2d|%5d %s\n",cardinalNum,originNum, (index>0)?"--- "+preOrigin%cardinalNum:"");
            System.out.println("  +------");
            res[index++] = tmp.charAt(originNum % cardinalNum);
            preOrigin = originNum;
            originNum /= cardinalNum;
            if(originNum == 0) {
                System.out.printf("%8d --- %d\n",originNum,preOrigin%cardinalNum);
            }
        } while(originNum != 0);

        for(int i = 0; i < index/2; i++) {
            t = res[i];
            res[i] = res[index - i -1 ];
            res[index - i -1] = t;
        }
        return index;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int originNum;
        int cardinalNum;
        char[] res = new char[20];

        System.out.println("10진수를 기수 변환합니다.");
        do {
            System.out.print("변환하는 음이 아닌 정수 : ");
            originNum = sc.nextInt();
        } while(originNum < 0);

        do {
            System.out.print("어떤 진수로 변환할까요?(2~36) : ");
            cardinalNum = sc.nextInt();
        }while(cardinalNum > 36 || cardinalNum < 2);

        int index = cardConv(res, originNum, cardinalNum);

        System.out.println(originNum+"는 "+ cardinalNum+"진수로 변환하면 ");
        for(int i = 0; i < index; i++) {
            System.out.print(res[i]);
        }
        System.out.println("입니다.");
    }
}
