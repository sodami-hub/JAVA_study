package ch15.Q08;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

    public static void main(String[] args) {
        Set<Student> set = new HashSet<Student>();
        set.add(new Student(1,"lee"));
        set.add(new Student(2,"kim"));
        set.add(new Student(1,"park"));

        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.studentNum +" : "+student.name);
        }
    }
}
