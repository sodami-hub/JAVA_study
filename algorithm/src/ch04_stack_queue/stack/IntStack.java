package ch04_stack_queue.stack;

public class IntStack {
    private int[] stack;
    private int ptr;
    private int capacity;


    public static class EmptyStackException extends RuntimeException {
        public EmptyStackException() {
            super("Stack is empty");
        }
    }

    public static class OverflowStackException extends RuntimeException {
        public OverflowStackException() {
            super("Stack overflow");
        }
    }

    public IntStack(int stackSize) {
        ptr = 0;
        capacity = stackSize;
        try{
            stack=new int[capacity];
        }catch(OutOfMemoryError e) {
            System.err.println(e.getMessage());
            capacity = 0;
        }
    }

    public int pop() throws EmptyStackException {
        if(ptr <= 0) {
            throw new EmptyStackException();
        }
        return stack[--ptr];
    }

    public void push(int data) throws OverflowStackException {
        if(ptr >= capacity) {
            throw new OverflowStackException();
        }
        stack[ptr++] = data;
    }

    public int peek() throws EmptyStackException {
        if(ptr <= 0) {
            throw new EmptyStackException();
        }
        return stack[ptr-1];
    }

    //스택을 비움
    public void clearStack() {
        ptr = 0;
    }

    // 스택에서 요소(key)를 찾아 줌
    public int indexOf(int key) {
        if(ptr <= 0) {
            throw new EmptyStackException();
        }
        int index=-1;
        for(int i=ptr-1; i>=0; i--  ) {
            if(stack[i]==key) {
                index = i;
            }
        }
        return index;
    }

    public int max() {
        return capacity;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr == 0;
    }

    public boolean isFull() {
        return ptr == capacity;
    }

    public void dump() {
        if(ptr <= 0) {
            throw new EmptyStackException();
        }
        System.out.print("MyStack[0]~[top] : ");
        for(int i=0; i<ptr;i++) {
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }
}
