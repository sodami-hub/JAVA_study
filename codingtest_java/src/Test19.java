import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Test19 {

    public static String mySol(String[] participant, String[] completion) {
        ArrayList<String> list = Arrays.stream(participant).collect(Collectors.toCollection(ArrayList::new));

        for (String s : completion) {
            for(int i =0; i<list.size(); i++) {
                if(s.equals(list.get(i))) {
                    list.remove(i);
                }
            }
        }
        return list.getFirst();
    }


    // Hash Map을 사용한 방식

    public static String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> hs = new HashMap<>();

        for (String s : participant) {
            hs.put(s,hs.getOrDefault(s,0) +1);
            //getOrDefault  -> ha.put(s)가 널이면 0을(실제값은 1이 들어감)
            //null이 아니면 hs.put(s)를 가져온다.(실제 입력값은 hs.put(s)+1)
        }
        
        for (String s : completion) {
            hs.put(s,hs.get(s)-1);
        }

        for (String s : hs.keySet()) {
            if(hs.get(s) != 0) {
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String result;
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};
        result = solution(participant,completion);
        System.out.println("result = " + result);
        result = mySol(participant,completion);
        System.out.println("myresult = " + result);

        String[] participant2 = {"mislav","stanko","mislav","ana"};
        String[] completion2 = {"stanko","ana","mislav"};
        result = solution(participant2,completion2);
        System.out.println("result = " + result);
        result = mySol(participant2,completion2);
        System.out.println("myresult = " + result);
    }

}
