package mystudy;

import java.util.ArrayList;
import java.util.List;

// 문자열 str의 각 문자로 만들 수 있는 모든 조합을 반환하는 함수
public class StringCombination {

    public static void combinations(int idx, char[] order, String result, List<String> list) {
        if(result.length() > 1){
            list.add(result);
        }

        for(int i = idx; i<order.length; i++) {
            combinations(i+1, order,result+order[i],list);
        }
    }

    public static void solution(String str, List<String> list) {
        combinations(0,str.toCharArray(),"", list);
    }


    public static void main(String[] args) {
        String str = "abcd";
        String[] array;
        List<String> list = new ArrayList<>();

        solution(str, list);

        for (String s : list) {
            System.out.println(s+" ");
        }
    }
}
