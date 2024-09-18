package mystudy;

import java.util.*;

/*
hashmap의 value로 sort를 해서 key값을 뽑아냄...
codingtest의 5,6번에서 쓸법한 방법들
 */

public class HashMapSortingExam {

    public static void main(String[] args) {

        TreeMap<Integer,String> hs = new TreeMap<>();
        hs.put(1,"B");
        hs.put(2,"A");
        hs.put(3,"E");
        hs.put(4,"D");

        ArrayList<String> valueSet = new ArrayList<>();
        for (int key : hs.keySet()) {
            valueSet.add(hs.get(key));
        }

        System.out.println(valueSet.toString());

        Collections.sort(valueSet);
        System.out.println(valueSet.toString());

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i<valueSet.size(); i++) {
            for(int key:hs.keySet()) {
                if(hs.get(key).equals(valueSet.get(i))) {
                    list.add(key);
                }
            }
        }
        int[] result = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(result));

    }

}

