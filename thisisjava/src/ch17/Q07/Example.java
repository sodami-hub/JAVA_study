package ch17.Q07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) {
        List<Member> list = Arrays.asList(
                            new Member("홍길동","개발자"),
                            new Member("김나리","디자이너"),
                            new Member("동동동","개발자")
                            );

        List<Member> dev = list.stream()
                .filter(s->s.getJob().equals("개발자")).toList();

        Stream<Member> stream = dev.stream();
        stream.forEach(n->System.out.println(n.getName()+" "+n.getJob()));
    }
}
