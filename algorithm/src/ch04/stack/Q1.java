package ch04.stack;

import java.util.Scanner;

//MyStack의 모든 메소드를 사용하는 메소드
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntStack s = new IntStack(6);
        int data;

        while(true) {
            System.out.println();
            System.out.println("현재 데이터 개수: "+ s.size()+"/"+s.max());
            System.out.print("1.푸시 2.팝 3.피크 4.덤프 5.스택비우기 6.요소찾기 0.종료 > ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("데이터 : ");
                    data = sc.nextInt();
                    try {
                        s.Push(data);
                    }catch(IntStack.OverflowStackException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        data = s.Pop();
                        System.out.println("팝한 데이터는 " + data + "입니다.");
                    } catch(IntStack.EmptyStackException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        data = s.Peak();
                        System.out.println("픽한 데이터는 "+data+"입니다.");
                    } catch(IntStack.EmptyStackException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("스택의 내용 : ");
                    try {
                        s.dump();
                    }catch(IntStack.EmptyStackException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("스택을 초기화합니다.");
                    s.clearStack();
                    break;
                case 6:
                    System.out.print("찾을 값을 입력하세요 > ");
                    data = sc.nextInt();
                    int index = s.indexOf(data);
                    if(index == -1) {
                        System.out.println("찾는 값이 없습니다.");
                    } else {
                        System.out.println("찾는 값은 "+index+"번지에 있습니다.");
                    }
                    break;
                case 0:
                    System.out.println("종료합니다. ");
                    break;
                default:
                    System.out.println("정확한 값을 입력하세요.");
                    break;
            }
            if(choice == 0 ) {
                break;
            }
        }
    }
}
