package ch14.Q8;

public class MovieThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("MovieThread");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){

            }
        }
    }
}
