package ch04.deque;

import ch04.queue.int_circle_queue.IntCircleQueue;

import java.util.Scanner;

public class IntDequeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntDeque que = new IntDeque(6);

        while(true) {
            System.out.println();
            System.out.printf("현재 데이터 개수: %d/%d\n", que.getSize(),que.getMaxSize());
            System.out.print("1.fpush 2.rpush 3.fpop 4.rpop 5.dump 0.exit >");
            int choice = sc.nextInt();
            if(choice == 0) {
                System.out.println("종료합니다.");
                break;
            }
            int item;
            switch(choice) {
                case 1:
                    try{
                        System.out.print("입력할 데이터 > ");
                        item = sc.nextInt();
                        que.fPush(item);
                    }catch(IntCircleQueue.QueueOverFlowException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try{
                        System.out.print("입력할 데이터 > ");
                        item = sc.nextInt();
                        que.rPush(item);
                    }catch(IntCircleQueue.QueueOverFlowException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try{
                        item= que.fPop();
                        System.out.println("꺼낸 데이터는 "+item+"입니다.");
                    } catch(IntCircleQueue.QueueUnderflowException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try{
                        item= que.rPop();
                        System.out.println("꺼낸 데이터는 "+item+"입니다.");
                    } catch(IntCircleQueue.QueueUnderflowException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        que.dump();
                    }catch(IntCircleQueue.QueueUnderflowException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("숫자를 다시 입력하세요.");
            }
        }
    }
}
