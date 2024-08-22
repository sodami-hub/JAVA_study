package ch01;


public class Q14_16 {
    static void triangleLB(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleLU(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = n; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleRU(int n) {
        for(int i = 1; i <= n; i++) {

            for(int k = 1; k < i; k++) {
                System.out.print(" ");
            }

            for(int j = n; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleRB(int n) {
        for(int i = 1; i <= n; i++) {

            for(int k = i; k < n; k++) {
                System.out.print(" ");
            }

            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void spira(int n) {
        int re;
        for (int i = 1; i <= n; i++) {
            for(int j = i; j< n; j++) {
                System.out.print(" ");
            }
            re = ((i-1)*2)+1;
            for(int k = 1; k <= re; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void npira(int n) {
        int re;
        for (int i = 1; i <= n; i++) {
            for(int j = i; j< n; j++) {
                System.out.print(" ");
            }
            re = ((i-1)*2)+1;
            for(int k = 1; k <= re; k++) {
                System.out.print(i%10);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        triangleLB(5);
        System.out.println();
        triangleLU(5);
        System.out.println();
        triangleRU(5);
        System.out.println();
        triangleRB(5);

        System.out.println();
        spira(8);
        System.out.println();
        npira(13);
    }
}
