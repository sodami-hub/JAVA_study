package ch04_stack_queue.queue.Q4;

public class Main {
    public static void main(String[] args) {
        IntArrayQueue queue = new IntArrayQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.dump();

        System.out.println(queue.dequeue());
        queue.dump();
    }
}
