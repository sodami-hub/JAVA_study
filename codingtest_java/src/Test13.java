import java.util.ArrayList;
import java.util.Stack;

public class Test13 {

    public static int solution(int[][] board, int[] moves) {

        ArrayList<Stack<Integer>> boards = new ArrayList<>(board.length);
        Stack<Integer> bucket = new Stack<>();
        int result=0;

        for(int i = 0 ; i<board.length ; i++) {
            Stack<Integer> newStack = new Stack<>();
            for(int j = board.length-1; j>=0; j-- ){
                if(board[j][i] != 0) {
                    newStack.push(board[j][i]);
                }
            }
            boards.add(newStack);
        }
        int pickValue;
        for(int i = 0 ; i<moves.length ; i++) {
            if(!boards.get(moves[i]-1).isEmpty()) {
                pickValue = boards.get(moves[i]-1).pop();
                System.out.println("pickValue = " + pickValue);
                if(bucket.isEmpty()) {
                    bucket.push(pickValue);
                } else {
                    if(pickValue == bucket.peek()) {
                        bucket.pop();
                        result += 2;
                    } else {
                        bucket.push(pickValue);
                    }
                    
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int result;
        result = solution(board,moves);
        System.out.println("result = " + result);
    }
}
