package ch01;

// 세 값의 최소값
public class Q2 {

    static int min3(int a, int b, int c) {
        int min=a;

        if(b<min) {
            min=b;
        }
        if(c<min) {
            min=c;
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(min3(1, 2, 3));
        System.out.println(min3(5, 3, 8));
        System.out.println(min3(234626, 243576468, 12346));
        System.out.println(min3(7234513, 2341, 1));
    }
}
