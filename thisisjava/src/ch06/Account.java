package ch06;

// Example19
public class Account {
    private int balance;

    final static int MIN_BALANCE = 0;
    final static int MAX_BALANCE = 1000000;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {

        if(MIN_BALANCE > balance || balance > MAX_BALANCE ) {
            return;
        } else {
            this.balance = balance;
        }
    }
}
