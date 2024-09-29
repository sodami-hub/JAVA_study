/*
문제20
 */

import java.util.HashMap;

public class Test20 {
    public static int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        boolean check;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i =0; i < want.length; i++) {
            hm.put(want[i],number[i]);
        }

        for(int i=0; i<= discount.length-10;i++) {
            check=true;
            for(int j = i; j< 10+i; j++) {
                if(!hm.containsKey(discount[j])) {
                    break;      //10일의 할인 행사품목중 하나라도 want에 없으면 중단.
                } else {
                    hm.put(discount[j], hm.get(discount[j])-1);
                }
            }
            for (String s : hm.keySet()) {
                if(hm.get(s) !=0) {
                    check = false;
                    break;
                };
            }
            if(check) result++;

            for(int k = 0; k < want.length; k++) {
                hm.put(want[k],number[k]);
            }

        }
        return result;
    }


    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork",
                            "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        int result = solution(want, number, discount);
        System.out.println("result = " + result);
    }
}
