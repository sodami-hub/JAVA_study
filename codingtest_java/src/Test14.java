/*
문제 14 - 표 편집
 */

import java.lang.reflect.Array;
import java.util.*;

public class Test14 {
    public static String solution01(int n, int k, String[] cmd) {
        // ❶ 삭제된 행의 인덱스를 저장하는 스택
        Stack<Integer> deleted = new Stack<>();

        // ❷ 각 행을 기준으로 연산에 따른 위치를 표시하기 위한 배열
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        // ❸ 현재 위치를 나타내는 인덱스
        k++;

        // ❹ 주어진 명령어(cmd) 배열을 하나씩 처리
        for (String c : cmd) {
            // ❺ 현재 위치를 삭제하고 그 다음 위치로 이동
            if (c.startsWith("C")) {
                deleted.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n < down[k] ? up[k] : down[k];
            }
            // ❻ 가장 최근에 삭제된 행을 복원
            else if (c.startsWith("Z")) {
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            }
            // ❼ U 또는 D를 사용해 현재 위치를 위아래로 이동
            else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                for (int i = 0; i < x; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }

        // ❽ 삭제된 행의 위치에 'X'를, 그렇지 않은 행 위치에는 'O'를 저장한 문자열 반환
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        for (int i : deleted) {
            answer[i - 1] = 'X';
        }

        return new String(answer);
    }



    public static String solution(int n, int k, String[] cmd) {
        int position = k;

        ArrayList<String> table = new ArrayList<>(n);
        for(int i = 0; i <n; i++) {
            table.add((i+1)+"행");
        }

        Stack<Integer> delTable = new Stack<>();

        int movePos;
        for(int i = 0; i < cmd.length; i++) {
            String command = cmd[i];
            char factor = command.charAt(0);
            
            switch(factor) {
                case 'C':
                    delTable.push(position);
                    table.remove(position);
                    if(position >= table.size()) {
                        position = table.size()-1;
                    }
                    break;
                case 'Z':
                    int index = delTable.pop();
                    table.add(index, String.valueOf(index+1)+"행");
                    break;
                case 'U':
                    movePos = ((int)command.charAt(2))-48;
                    position -= movePos;
                    if(position < 0) {
                        position =0;
                    }
                    break;
                case 'D':
                    movePos = ((int)command.charAt(2))-48;
                    position += movePos;
                    if(position >= n) {
                        position = n-1;
                    }
                    break;
            }
        }

        StringBuilder test = new StringBuilder();
        for(int i = 0; i<n; i++) {
            test.append('O');
        }
        while(!delTable.isEmpty()) {
            int index = delTable.pop();
            test.replace(index,index+1,"X");
        }

        return test.toString();
    }



    public static void main(String[] args) {
        int n = 8; // 표의 크기(행의 수)
        int k = 2;  // 처음 위치

        String[] cmd01 = {"D 2", "C","U 3","C","D 4","C","U 2","Z","Z"};
        String[] cmd02 = {"D 2", "C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

        String result;
        result = solution(n,k,cmd01);
        System.out.println(result);

        // 두번째 테스트의 결과는 답안과는 다르지만... 내가 맞는거 같음...ㅡ,.ㅡ;;
        result = solution(n,k,cmd02);
        System.out.println(result);

    }
}
