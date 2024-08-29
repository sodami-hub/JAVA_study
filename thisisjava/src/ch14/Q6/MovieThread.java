package ch14.Q6;

public class MovieThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("MovieThread");

            if(this.isInterrupted()) {
                System.out.println("interrupted");
                break;
            }
        }




    }
}
