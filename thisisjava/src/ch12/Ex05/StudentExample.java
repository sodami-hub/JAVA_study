package ch12.Ex05;

import java.util.HashSet;

public class StudentExample {

    public static void main(String[] args) {
        HashSet<Student> hs = new HashSet<Student>();

        hs.add(new Student("1"));
        hs.add(new Student("1"));
        hs.add(new Student("2"));

        System.out.println("저장된 Student의 수 :"+hs.size());
    }
}
