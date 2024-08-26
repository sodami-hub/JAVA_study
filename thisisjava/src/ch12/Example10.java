package ch12;

public class Example10 {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            str.append(i);
        }
        String st = str.toString();
        System.out.println(st);

    }
}
