package ch04.stack.Q3;

//ch04.Q3
public class DoubleStack {
    private int[] stackArr;

    private FS fStack;
    private RS rStack;

    private int capacity;

    public static class StackOverFlowException extends RuntimeException {
        public StackOverFlowException() {
            super("Stack is Full");
        }
    }
    public static class StackUnderFlowException extends RuntimeException {
        public StackUnderFlowException() {
            super("Stack is Empty");
        }
    }

    public DoubleStack(int capacity) {
        this.capacity = capacity;
        try {
            stackArr = new int[capacity];
            fStack = new FS();
            rStack = new RS();
            rStack.rPtr = 0;
            fStack.fPtr = 0;
        } catch(OutOfMemoryError e) {
            capacity = 0;
            System.err.println(e.getMessage());
        }
    }

    public boolean checkMemory() {
        if((fStack.fPtr + rStack.rPtr) >= capacity) {
            return true;
        } else {
            return false;
        }
    }

    public boolean fIsEmpty() {
        return (fStack.fPtr <= 0);
    }
    public boolean rIsEmpty() {
        return (rStack.rPtr <= 0);
    }

    public void fPush(int data) {
        if(checkMemory()) {
            throw new StackOverFlowException();
        }
        stackArr[fStack.fPtr++] = data;
    }
    public void rPush(int data) {
        if(checkMemory()) {
            throw new StackOverFlowException();
        }
        stackArr[capacity-rStack.rPtr-1] = data;
        rStack.rPtr++;
    }

    public int fPop() {
        if(fIsEmpty()) {
            throw new StackUnderFlowException();
        }
        return stackArr[--fStack.fPtr];
    }

    public int rPop() {
        if(rIsEmpty()) {
            throw new StackUnderFlowException();
        }
        return stackArr[capacity-(rStack.rPtr--)];
    }

    public int fPeek() {
        if(fIsEmpty()) {
            throw new StackUnderFlowException();
        }
        return stackArr[fStack.fPtr-1];
    }
    public int rPeek() {
        if(rIsEmpty()) {
            throw new StackUnderFlowException();
        }
        return stackArr[capacity-rStack.rPtr];
    }

    public void fDump() {
        System.out.print("FrontStack[top] ~ [0] : ");
        for(int i = fStack.fPtr-1 ; i >= 0; i--) {
            System.out.print(stackArr[i] + " ");
        }
        System.out.println();
    }
    public void rDump() {
        System.out.print("FrontStack[top]~[0] : ");
        for(int i = capacity - fStack.fPtr; i < capacity; i++) {
            System.out.print(stackArr[i] + " ");
        }
        System.out.println();
    }
}
