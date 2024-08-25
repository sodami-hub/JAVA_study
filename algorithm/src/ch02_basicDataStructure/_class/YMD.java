package ch02_basicDataStructure._class;


import java.util.Scanner;

//ch02 - Q8
public class YMD {
    int y;
    int m;
    int d;

    YMD(int y, int m, int d) {
        this.y = y;
        if(m< 1 || m>12){
            System.out.println("1~12월 까지만 설정 가능");
            return;
        }else {
            this.m = m;
        }
        if(d< 1 || d>31){
            System.out.println("1~31일 까지만 설정 가능");
            return;
        }else {
            this.d = d;
        }
    }

    public YMD after(int n) {
        YMD temp = new YMD(this.y, this.m, this.d);


        if(temp.d +n > 31 ) {
            if(temp.m == 12) {
                temp.y++;
                temp.m = 1;
            } else {
                temp.m++;
            }
            temp.d = (temp.d+n)-31;
            return temp;
        } else {
            temp.d +=n;
            return temp;
        }
    }

    public YMD before(int n) {
        YMD temp = new YMD(this.y, this.m, this.d);

        if(temp.d-n < 0 ) {
            if(temp.m == 1) {
                temp.y--;
                temp.m = 12;
            } else {
                temp.m++;
            }
            temp.d = (temp.d-n) +31;
            return temp;
        } else {
            temp.d -= n;
            return temp;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("날짜를 입력하세요.\n");
        System.out.print("년 : ");  int y = stdIn.nextInt();
        System.out.print("월 : ");  int m = stdIn.nextInt();
        System.out.print("일 : ");  int d = stdIn.nextInt();
        YMD date = new YMD(y, m, d);

        System.out.print("며칠 전/후의 날짜를 구할까요? : ");
        int n = stdIn.nextInt();

        YMD d1 = date.after(n);
        System.out.printf("%d일 후의 날짜는 %d년%d월%d일입니다.\n", n, d1.y, d1.m, d1.d);

        YMD d2 = date.before(n);
        System.out.printf("%d일 전의 날짜는 %d년%d월%d일입니다.\n", n, d2.y, d2.m, d2.d);


    }
}
