package ch12;

public class Example08 {
    public static void main(String[] args) {
        long now1 = System.nanoTime();
        int[] scores = new int[1000];
        for(int i = 0; i < scores.length; i++) {
            scores[i] = i;
        }

        int sum = 0;
        for(int score : scores) {
            sum += score;
        }

        double avg = sum/(double)scores.length;
        System.out.println("Average score: " + avg);
        long now2 = System.nanoTime();
        System.out.println("times : " +(now2 - now1) +"ns");

    }
}
