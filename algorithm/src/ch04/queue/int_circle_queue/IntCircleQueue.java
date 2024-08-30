package ch04.queue.int_circle_queue;

import java.net.StandardSocketOptions;


// 원형 큐 만들기 + Q5
public class IntCircleQueue {
    private int[] que;
    private int front;
    private int rear;
    private int size;
    private int maxSize;


    public static class QueueOverFlowException extends RuntimeException {
        public QueueOverFlowException() {
            super("Queue is Full");
        }
    }

    public static class QueueUnderflowException extends RuntimeException {
        public QueueUnderflowException() {
            super("Queue is Empty");
        }
    }

    public IntCircleQueue(int capacity) {
        try{
            que = new int[capacity];
            maxSize = capacity;
            front = 0;
            rear = 0;
            size = 0;
        } catch(OutOfMemoryError e) {
            capacity= 0;
        }
    }

    public void enqueue(int item) throws QueueOverFlowException {
        if(size==maxSize) {
            throw new QueueOverFlowException();
        }
        que[rear] = item;
        rear = (rear+1)%maxSize;
        size++;
    }

    public int dequeue() throws QueueUnderflowException {
        if(size==0) {
            throw new QueueUnderflowException();
        }
        int item = que[front];
        front = (front+1)%maxSize;
        size--;

        return item;
    }

    public void dump() {
        if(size==0) {
            throw new QueueUnderflowException();
        }
        System.out.print("queue[f]~[r] : ");
        for(int i=front; i<size+front; i++) {
            if(i>=maxSize) {
                System.out.print(que[i-maxSize]+" ");
                continue;
            }
            System.out.print(que[i]+" ");

        }
        System.out.println();
    }

    public int peek() throws QueueUnderflowException {
        if(size==0) {
            throw new QueueUnderflowException();
        }
        return que[front];
    }

    public int indexOf(int item) throws QueueUnderflowException {
        if(size==0) {
            throw new QueueUnderflowException();
        }
        for(int i=front;i<rear;i++) {
            if(que[i]==item) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==maxSize;
    }

    public int getSize() {
        return size;
    }
    public int getMaxSize() {
        return maxSize;
    }

    //Q5
    public int search(int item) throws QueueUnderflowException {
        if(size==0) {
            throw new QueueUnderflowException();
        }
        for(int i=front;i<size+front;i++) {
            if(i >= maxSize) {
                if(que[i-maxSize] == item) {
                    return (i-front)+1;
                }
                continue;
            }
            if(que[i]==item) {
                return (i-front)+1;
            }
        }
        return -1;
    }

}
