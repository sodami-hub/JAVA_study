package ch14.Q2;

public class ThreadExample {

    public static void main(String[] args) {
        Thread thread01 = new MovieThread();
        thread01.start();

        MusicRunnable mr = new MusicRunnable();
        Thread thread02 = new Thread(mr);
        thread02.start();
    }

}
