package ch01;

public class Q12 {
    public static void main(String[] args) {
        int tmp = 0;

        for (int j = 0; j <= 9; j++) {
            if (j == 0) {
                System.out.print("   |");
                continue;
            }
            System.out.printf("%3d", j);

            while (j == 9) {
                if (tmp == 0) {
                    System.out.print("\n---+");
                }
                tmp++;
                System.out.print("---");
                if (tmp == 10) {
                    break;
                }
            }
        }
        System.out.println();

        for (int i = 1; i<=9; i++) {
            System.out.printf("%3d|",i);
            for(int j= 1 ; j<=9 ; j++) {
                System.out.printf("%3d",j+i);
            }
            System.out.println();
        }
    }
}
