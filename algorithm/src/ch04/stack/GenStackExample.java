package ch04.stack;

public class GenStackExample {
    public static void main(String[] args) {
        GenStack<String> stack = new GenStack<String>(10);
        stack.push("이");
        stack.push("진");
        stack.push("헌");
        stack.push("이");
        stack.push("소");
        stack.push("담");
        stack.push("이");

        int index = stack.indexOf("소");
        System.out.println("찾는 값의 index는 stack["+index+"]입니다.");
        stack.dump();

        GenStack<Integer> stack2 = new GenStack<Integer>(10);
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        stack2.push(6);
        stack2.push(7);
        index = stack2.indexOf(4);
        System.out.println("찾는 값의 index는 stack["+index+"]입니다.");
        stack2.dump();
    }
}
