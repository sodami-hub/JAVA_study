package ch17;

import java.util.Arrays;
import java.util.List;

public class Q05 {
    public static void main(String[] args) {
        //
        List<String> list = Arrays.asList("This is a Java book",
                                            "Lambda Expression",
                                            "Java8 supports lambda expressions");

        list.stream()
                .filter(n->n.contains("Java"))
                .forEach(System.out::println);

    }
}
