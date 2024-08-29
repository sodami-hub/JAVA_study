package ch14.Q6;

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new MovieThread();
        thread.start();

        try{
            Thread.sleep(500);
        } catch(InterruptedException e){
        }

        thread.interrupt();
    }
}
