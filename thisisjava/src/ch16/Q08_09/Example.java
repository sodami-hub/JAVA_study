package ch16.Q08_09;

public class Example {
    private static Student[] students = {
            new Student("홍길동", 90,96),
            new Student("신용권",95,93)
    };

    public static double avg(Function<Student> fun) {
        double total = 0;

        for(int i = 0; i < students.length; i++) {
            double result = fun.apply(students[i]);
            total += result;
        }

        return total / students.length;
    }
    
    public static void main(String[] args) {

        //Q8
        double englishAvg = avg(s->s.getEngScore());
        System.out.println("영어 평균 = " + englishAvg);
        
        double mathAvg = avg(s->s.getMathScore());
        System.out.println("수학 평균 = " + mathAvg);

        System.out.println();

        //Q9
        englishAvg = avg(Student::getEngScore);
        System.out.println("영어 평균 = " + englishAvg);

        mathAvg = avg(Student::getMathScore);
        System.out.println("수학 평균 = " + mathAvg);

    }
}
