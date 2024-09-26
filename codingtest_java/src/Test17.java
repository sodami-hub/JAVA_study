public class Test17 {
    public static String solution(String[] arr1, String[] arr2, String[] goal) {

        int curArr1=0; // arr1의 index 커서
        int curArr2=0; // arr2의 index 커서
        
        for(int i = 0; i<goal.length; i++) {
            String value = goal[i];
            if(curArr1 < arr1.length && arr1[curArr1].equals(value)) {
                curArr1++;
            } else if (curArr2 < arr2.length && arr2[curArr2].equals(value)) {
                curArr2++;
            } else {
                return "NO";
            }
        }
        return "Yes";
    }

    public static void main(String[] args) {
        String[] arr1 = {"i","drink","water"};
        String[] arr2 = {"want", "to"};
        String[] goal = {"i","want","to","drink","water"};
        
        String result = solution(arr1,arr2,goal);
        System.out.println("result = " + result);
    }
}
