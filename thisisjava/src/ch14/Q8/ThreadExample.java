package ch14.Q8;

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new MovieThread();
        thread.setDaemon(true);
        thread.start();

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){

        }
        System.out.println("main thread exiting");
    }
}
