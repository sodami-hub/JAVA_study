package ch14.Q2;

public class MovieThread extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println("영화를 재생한다.");
        }
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
