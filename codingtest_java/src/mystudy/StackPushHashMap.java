package mystudy;

import java.util.HashMap;
import java.util.Stack;

public class StackPushHashMap {
    public static void main(String[] args) {
        Stack<HashMap<Integer,String>> stack = new Stack<>();
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        stack.push(map);
        map =new HashMap<>();
        map.put(2,"b");
        stack.push(map);


        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
