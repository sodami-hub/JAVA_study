package ch15.Q09;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("blue",96);
        map.put("hong",86);
        map.put("white",92);

        String name = null;
        int maxScore = 0;
        int totalScore = 0;

        Set<String> keys = map.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            totalScore += map.get(key);
            if(map.get(key)>maxScore){
                maxScore = map.get(key);
                name = key;
            }
        }
        System.out.println("평균 점수 : "+Math.floor((totalScore /(double)map.size())*100)/100.0);
        System.out.println("최고 점수  : " +maxScore);
        System.out.println("최고 점수를 받은 아이디 : " +name);

    }
}