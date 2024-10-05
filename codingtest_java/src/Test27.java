import java.util.Arrays;
import java.util.HashMap;

public class Test27 {

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] result = new int[enroll.length];

        HashMap<String, Integer> enrollIndex = new HashMap<>();
        for(int i = 0; i< enroll.length; i++) {
            enrollIndex.put(enroll[i],i);
        }

        HashMap<String,String> enrollAndReferral = new HashMap<>();
        for(int i =0; i< enroll.length; i ++) {
            enrollAndReferral.put(enroll[i],referral[i]);
        }

        int targetPersonTotalIncome;
        int targetPersonIncome;
        int payToReferral;

        String targetPerson ="";
        int targetIndex;

        for (int i = 0; i < seller.length; i++) {
            targetPerson = seller[i];
            targetPersonTotalIncome = (amount[i]*100);

            while(!targetPerson.equals("-")) {
                if(targetPersonTotalIncome < 10) {
                    targetIndex = enrollIndex.get(targetPerson);
                    result[targetIndex] += targetPersonTotalIncome;

                    break;
                } else {
                    payToReferral = (int)(targetPersonTotalIncome*0.1);
                    targetPersonIncome = targetPersonTotalIncome-payToReferral;

                    targetIndex = enrollIndex.get(targetPerson);
                    result[targetIndex] += targetPersonIncome;

                    targetPerson = enrollAndReferral.get(targetPerson);
                    targetPersonTotalIncome = payToReferral;
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        int[] result = solution(enroll, referral, seller, amount);
        System.out.println(Arrays.toString(result));


    }
}
