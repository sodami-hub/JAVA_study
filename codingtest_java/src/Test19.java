import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Test19 {
    public static String solution(String[] participant, String[] completion) {
        Set<String> set = Arrays.stream(participant).collect(Collectors.toSet());

        for (String s : completion) {
            set.remove(s);
        }

        return set.toString();
    }

    public static void main(String[] args) {
        String result;
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};
        result = solution(participant,completion);
        System.out.println("result = " + result);
    }

}
