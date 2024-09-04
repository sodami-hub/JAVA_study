package ch17.Q08;

import ch17.Q08.Member;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) {
        List<Member> list = Arrays.asList(
                new Member("홍길동", "개발자"),
                new Member("김나리", "디자이너"),
                new Member("신용권", "개발자")
        );

        Map<String, List<Member>> groupingMap = list.stream()
                .collect(Collectors.groupingBy(s -> s.getJob()));

        System.out.println("[개발자]");
        groupingMap.get("개발자").stream().forEach(System.out::println);

        System.out.println();

        System.out.println("[디자이너]");
        List<Member> degList = groupingMap.get("디자이너");
        degList.stream().forEach(n -> System.out.println(n));
    }
}
