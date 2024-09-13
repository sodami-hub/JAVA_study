/*
문제 02 - 배열 제어하기
중복값 제거, 내림차순 정렬
*/


import java.util.*;

public class Test02 {

    static Comparator<Integer> comp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1>o2) {
                return -1;
            } else {
                return 1;
            }
        }
    };
    // 나의 처음 풀이
    public static void sol01(int[] arr) {
        //Set 에 넣어서 중복값 제거
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i<arr.length; i++) {
            hs.add(arr[i]);
        }

        //Set에서 다시 Array로 카피
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer h : hs) {
            res.add(h);
        }

        //Comparator 객체로 내림차순 정렬
        res.sort(comp);

        for (Integer re : res) {
            System.out.print(re+" ");
        }
    }

    // 스트림을 이용한 풀이
    public static int[] sol02(int[] arr) {
        Integer[] temp = Arrays.stream(arr).distinct().boxed().toArray(Integer[]::new);
        Arrays.sort(temp, Collections.reverseOrder());
        int[] array = Arrays.stream(temp).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(array));
        return array;
    }

    // TreeSet을 사용한 풀이
    public static void sol03(int[] arr) {
        TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < arr.length; i++) {
            ts.add(arr[i]);
        }
        int[] array = new int[ts.size()];
        int i=0;
        for (Integer t : ts) {
            array[i] = t;
            i++;
        }

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] arr = {2,1,1,3,2,5,4};

        sol03(arr);
    }
}
