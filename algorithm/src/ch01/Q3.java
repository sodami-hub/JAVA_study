package ch01;

// 네 값의 최소값
public class Q3 {
    static int min4(int a, int b, int c, int d) {
        int min=a;

        if(b<min) {
            min=b;
        }
        if(c<min) {
            min=c;
        }
        if(d<min) {
            min=d;
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(min4(1, 2, 3, 42));
        System.out.println(min4(5, 3, 8, 1));
        System.out.println(min4(234626, 243576468, 123,12346));
        System.out.println(min4(7234513, 2341, 1,0));
    }
}
