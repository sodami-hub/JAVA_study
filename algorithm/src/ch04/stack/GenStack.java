package ch04.stack;

//ch04.Q02
public class GenStack<E> {
    private E[] stack;
    private int capacity;
    private int ptr;

    public static class StackOverFlow extends RuntimeException{
        public StackOverFlow(){
            super("Stack overflow");
        }
    }

    public static class StackIsEmpty extends RuntimeException{
        public StackIsEmpty(){
            super("Stack underflow");
        }
    }

    public GenStack(int capacity){
        this.capacity = capacity;
        ptr = 0;
        try {
            stack = (E[]) new Object[capacity];
        } catch(OutOfMemoryError e){
            System.out.println("Out of memory");
        }
    }

    public void push(E e){
        if(ptr == capacity){
            throw new StackOverFlow();
        }
        stack[ptr++] = e;
    }

    public E pop() {
        if(ptr == 0){
            throw new StackIsEmpty();
        }
        return stack[--ptr];
    }

    public E peak() {
        if(ptr == 0){
            throw new StackIsEmpty();
        }
        return stack[ptr-1];
    }

    public boolean isEmpty(){
        return ptr == 0;
    }

    public boolean isFull(){
        return ptr == capacity;
    }

    public int size(){
        return ptr;
    }

    public int max() {
        return capacity;
    }

    public int indexOf(E key) {
        if(ptr <= 0) {
            throw new StackIsEmpty();
        }
        int index=-1;
        for(int i=ptr-1; i>=0; i--  ) {
            if(stack[i].equals(key)){
                index = i;
            }
        }
        return index;
    }

    public void dump() {
        if(ptr <= 0) {
            throw new StackIsEmpty();
        }
        System.out.print("Stack의 내용물[top] ~ [0] : ");
        for(int i= ptr-1; i>=0; i--) {
            System.out.print(stack[i]);
        }
        System.out.println();
    }
}
