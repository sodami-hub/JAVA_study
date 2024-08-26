package ch12.Ex05;

public class Student {
    private String studentNum;

    public Student(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        return this.studentNum.equals(student.getStudentNum());
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(studentNum);
    }
}
