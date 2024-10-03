import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test24 {

    private static HashMap<String,Integer> ordersAndCourse = new HashMap<>();

    public static void combinations(int idx, char[] order, String result) {
        if(result.length() > 1) {
            char[] res = result.toCharArray();
            Arrays.sort(res);
            result = String.valueOf(res);
            ordersAndCourse.put(result, ordersAndCourse.getOrDefault(result,0)+1);
        }

        for(int i =idx; i<order.length; i++) {
            combinations(i+1, order, result+order[i]);
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        for (String order : orders) {
            combinations(0, order.toCharArray(), "");
        }

        for (int i : course) {
            int max = 1;
            for (String menus : ordersAndCourse.keySet()) {
                if(menus.length() == i) {
                    if(ordersAndCourse.get(menus) > max) {
                        max = ordersAndCourse.get(menus);
                    }
                }
            }
            if(max == 1) continue;
            for (String menus : ordersAndCourse.keySet()) {
                if(menus.length() == i) {
                    if(ordersAndCourse.get(menus) == max) {
                        result.add(menus);
                    }
                }
            }
        }
        String[] res = result.toArray(new String[0]);
        Arrays.sort(res);
        return res;
    }

    public static void main(String[] args) {
        String[] result;
//        String[] orders = {"ABCFG","AC","CDE","ACDE","BCFG","ACDEH"};
//        int[] course ={2,3,4};
//        result = solution(orders,course);
//        System.out.println(Arrays.toString(result));

//        String[] orders2 = {"ABCDE","AB","CD","ADE","XYZ","XYZ","ACD"};
//        int[] course2 ={2,3,5};
//        result = solution(orders2,course2);
//        System.out.println(Arrays.toString(result));

        String[] order3 = {"XYZ","XWY","WXA"};
        int[] course3 ={2,3,4};
        result = solution(order3,course3);
        System.out.println(Arrays.toString(result));
    }
}
