package ch01;

// Q4 Q5 세 값의 대소 관계인 13가지 조합의 중앙값을 구하기.
public class Q4 {

    static int mid(int a, int b, int c) {
        if(a >= b) {
            if (b >= c) {
                return b;
            } else if (c >= a) {
                return a;
            } else {
                return c;
            }
        }else if (a > c) {
            return a;
        }else if (b > c) {
            return c;
        }else {
            return b;
        }


    }

    static int mid2(int a, int b,int c) {
        if(b<= a && a<= c  || c<= a && a<= b) {
            return a;
        } else if(a <= b && b<= c || c<= b && b<= a) {
            return b;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        System.out.println("mid(3,2,1) = " + mid(3, 2, 1));        // [A] a＞b＞c
        System.out.println("mid(3,2,2) = " + mid(3, 2, 2));        // [B] a＞b＝c
        System.out.println("mid(3,1,2) = " + mid(3, 1, 2));        // [C] a＞c＞b
        System.out.println("mid(3,2,3) = " + mid(3, 2, 3));        // [D] a＝c＞b
        System.out.println("mid(2,1,3) = " + mid(2, 1, 3));        // [E] c＞a＞b
        System.out.println("mid(3,3,2) = " + mid(3, 3, 2));        // [F] a＝b＞c
        System.out.println("mid(3,3,3) = " + mid(3, 3, 3));        // [G] a＝b＝c
        System.out.println("mid(2,2,3) = " + mid(2, 2, 3));        // [H] c＞a＝b
        System.out.println("mid(2,3,1) = " + mid(2, 3, 1));        // [I} b＞a＞c
        System.out.println("mid(2,3,2) = " + mid(2, 3, 2));        // [J] b＞a＝c
        System.out.println("mid(1,3,2) = " + mid(1, 3, 2));        // [K] b＞c＞a
        System.out.println("mid(2,3,3) = " + mid(2, 3, 3));        // [L] b＝c＞a
        System.out.println("mid(1,2,3) = " + mid(1, 2, 3));        // [M] c＞b＞a

    }
}
