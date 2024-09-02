package ch04_stack_queue.deque;


//Q7 - deque 양방향 대기열
public class IntDeque {

    private int[] arr;

    private int maxSize;
    private int size;

    private int front;
    private int rear;

    public static class DequeOverFlowException extends RuntimeException {
        public DequeOverFlowException() {
            super("deque is full");
        }
    }
    public static class DequeUnderFlowException extends RuntimeException {
        public DequeUnderFlowException() {
            super("deque is empty");
        }
    }

    public IntDeque(int capacity) {
        maxSize = capacity;
        size = front = rear = 0;
        try {
            arr = new int[maxSize];
        } catch (OutOfMemoryError e) {
            maxSize=0;
        }
    }

    public void fPush(int x) {
        if(size == maxSize) {
            throw new DequeOverFlowException();
        }
        if(front == 0) {
            arr[maxSize-1] = x;
            front = maxSize-1;
        } else {
            arr[--front] = x;
        }
        size++;
    }

    public void rPush(int x) {
        if(size == maxSize) {
            throw new DequeOverFlowException();
        }
        if(rear == maxSize-1) {
            arr[rear] = x;
            rear=0;
        }else {
            arr[rear++] = x;
        }
        size++;
    }

    public int fPop() {
        if(size == 0) {
            throw new DequeUnderFlowException();
        }
        int item = arr[front];
        if(front == maxSize-1) {
            front = 0;
        } else {
            front = front + 1;
        }
        size--;
        return item;
    }

    public int rPop() {
        if(size == 0) {
            throw new DequeUnderFlowException();
        }
        int item;

        if(rear == 0) {
            item = arr[maxSize-1];
            rear = maxSize-1;
        } else {
            item = arr[--rear];
        }
        size--;
        return item;
    }

    public void dump() {
        System.out.print("deque[f]~[r] : ");
        for(int i=front; i<front+size; i++) {
            if(i >= maxSize) {
                System.out.print(arr[i-maxSize]+" ");
                continue;
            }
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public int getMaxSize() {
        return maxSize;
    }
}
