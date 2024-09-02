package ch04_stack_queue.queue.Q4;

import java.util.Arrays;

public class IntArrayQueue {
    private int[] que;
    private int capacity;
    private int num;

    public IntArrayQueue(int capacity) {
        try {
            this.num = 0;
            this.capacity = capacity;
            que = new int[capacity];
        } catch(OutOfMemoryError e) {
            this.capacity = 0;
        }
    }

    public static class QueueOverFlow extends RuntimeException {
        public QueueOverFlow() {
            super("Queue is Full");
        }
    }

    public static class QueueUnderFlow extends RuntimeException {
        public QueueUnderFlow() {
            super("Queue is Empty");
        }
    }


    public boolean isEmpty() {
        if(num == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return this.num;
    }

    public void enqueue(int x) {
        if(num == capacity) {
            throw new QueueOverFlow();
        }
        que[num] = x;
        num++;
    }

    public int dequeue() {
        if(num == 0) {
            throw new QueueUnderFlow();
        }
        int res = que[0];
        int[] temp = Arrays.copyOfRange(que,1,num);
        num--;
        que = Arrays.copyOfRange(temp,0,num);
        return res;
    }

    public void dump() {
        for(int i = 0 ; i < num ; i++) {
            System.out.print(que[i] + " ");
        }
        System.out.println();
    }

}
