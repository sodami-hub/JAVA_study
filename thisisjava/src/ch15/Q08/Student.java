package ch15.Q08;

public class Student {
    public int studentNum;
    public String name;

    public Student(int num, String name) {
        this.studentNum = num;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.studentNum;
    }

    @Override
    public boolean equals(Object obj) {
        return studentNum==((Student)obj).studentNum;
    }
}
