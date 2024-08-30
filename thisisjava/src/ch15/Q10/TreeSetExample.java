package ch15.Q10;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<Student>();

        ts.add(new Student("Jack", 88));
        ts.add(new Student("blue", 96));
        ts.add(new Student("hong", 86));
        ts.add(new Student("white", 92));

        Student st = ts.last();
        System.out.println(st.score);
        System.out.println(st.id);
    }
}
