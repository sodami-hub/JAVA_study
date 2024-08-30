package ch04.queue.int_circle_queue;

import java.util.Scanner;

public class IntCircleQueueMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntCircleQueue que = new IntCircleQueue(6);

        while(true) {
            System.out.println();
            System.out.printf("현재 데이터 개수: %d/%d\n", que.getSize(),que.getMaxSize());
            System.out.print("1.enque 2.deque 3.peek 4.dump 5.search 0.exit >");
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
                        que.enqueue(item);
                    }catch(IntCircleQueue.QueueOverFlowException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try{
                        item= que.dequeue();
                        System.out.println("꺼낸 데이터는 "+item+"입니다.");
                    } catch(IntCircleQueue.QueueUnderflowException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try{
                        item = que.peek();
                        System.out.println("다음 데이터는 "+item+"입니다.");
                    } catch(IntCircleQueue.QueueUnderflowException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        que.dump();
                    } catch(IntCircleQueue.QueueOverFlowException e) {
                        System.out.println(e.getMessage());

                    }
                    break;
                case 5:
                    System.out.print("찾고 싶은 데이터 > ");
                    item = sc.nextInt();
                    try {
                        int index = que.search(item);
                        System.out.println("찾는 데이터는 " + index+"번째에 있습니다.");
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

