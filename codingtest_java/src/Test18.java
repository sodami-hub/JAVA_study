import java.util.HashSet;


public class Test18 {

    public static boolean solution(int[] array, int target) {

        for(int i = 0; i<array.length-1; i++) {
            for(int j=i+1; j<array.length ;j++) {
                int value = array[i] + array[j];
                if (value == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean solutionUseSet(int[] array, int target) {
        HashSet<Integer> set = new HashSet<>();

        for(int i : array) {
            if(set.contains(target-i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,8};
        int target = 6;
        //boolean result = solution(arr,target);
        boolean result = solutionUseSet(arr,target);
        System.out.println("result = " + result);

        int[] arr02 = {2,3,5,9};
        target= 10;
//        result = solution(arr02,target);
        result = solutionUseSet(arr02,target);
        System.out.println(result);

    }
}
