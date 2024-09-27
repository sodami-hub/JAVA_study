import java.util.HashMap;

public class Test19 {
    public static String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> hs = new HashMap<>();

        for (String s : participant) {
            hs.put(s,hs.getOrDefault(s,0) +1);
        }
        System.out.println("hs = " + hs);
        
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

        String[] participant2 = {"mislav","stanko","mislav","ana"};
        String[] completion2 = {"stanko","ana","mislav"};
        result = solution(participant2,completion2);
        System.out.println("result = " + result);
    }

}
