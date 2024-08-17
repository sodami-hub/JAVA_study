package ch06;

//Ex20
public class BankAccount {
    private String accountNum;
    private String name;
    private String initBalance;

    public String getInitBalance() {
        return initBalance;
    }

    public void setInitBalance(String initBalance) {
        if(Integer.parseInt(initBalance) < 0) {
            System.out.println("초기 입금액은 0원 이상이어야 됩니다.");
        } else {
            this.initBalance = initBalance;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }
}
