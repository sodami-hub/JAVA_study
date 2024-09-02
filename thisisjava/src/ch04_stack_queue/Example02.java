package ch04_stack_queue;

public class Example02 {
    public static void main(String[] args) {
        String grade ="B";

        int score1 = switch(grade) {
            case "A" -> 100;
            case "B" -> {
                int result = 100 -20;
                yield result;
            }
            default -> 60;
        };

        System.out.println("당신의 점수는 : "+score1 );
    }
}
