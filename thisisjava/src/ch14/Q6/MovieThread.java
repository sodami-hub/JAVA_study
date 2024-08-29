package ch14.Q6;

public class MovieThread extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("MovieThread");

                Thread.sleep(1);
            }
        }catch(InterruptedException e) {}

        System.out.println("break");

    }
}
