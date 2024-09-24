package mystudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayToListConvertExam {
    public static void main(String[] args) {
        // String[] -> ArrayList<String>
        String[] arr = {"1","2","3"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));

        // int[] -> ArrayList<Integer>
        int[] array = new int[] {1,2,3,4};
        ArrayList<Integer> intList;
        intList = Arrays.stream(array).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
}
