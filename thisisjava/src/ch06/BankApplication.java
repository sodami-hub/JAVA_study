package ch06;

import java.util.Scanner;

//Ex20
public class BankApplication {
    BankAccount[] accounts = new BankAccount[100];
    Scanner sc = new Scanner(System.in);
    int count = 0;

    void CreateAccount() {
        String accountNum;
        String name;
        String initBal;
        System.out.println("---------");
        System.out.println("계좌생성");
        System.out.println("---------");
        System.out.print("계좌번호 : ");
        accountNum = sc.nextLine();
        System.out.print("계 좌 주 : ");
        name = sc.nextLine();
        System.out.print("초기금액 : ");
        initBal = sc.nextLine();

        BankAccount newAccount = new BankAccount();
        newAccount.setAccountNum(accountNum);
        newAccount.setName(name);
        newAccount.setInitBalance(initBal);

        accounts[count] = newAccount;

        count += 1;
    }

    void AccountList() {
        System.out.println("---------");
        System.out.println("계좌목록");
        System.out.println("---------");

        for(int i = 0; i<count; i++) {
            System.out.println(accounts[i].getAccountNum() + " " + accounts[i].getName() + " " + accounts[i].getInitBalance());
        }
    }

    int FindAccount(String accountNum) {
        for(int i = 0; i<count; i++) {
            if(accounts[i].getAccountNum().equals(accountNum)) {
                return i;
            }
        }
        return -1;
    }

    int StringToInt(String input) {
        return Integer.parseInt(input);
    }

    void Deposit() {

        System.out.println("---------");
        System.out.println("입금");
        System.out.println("---------");
        System.out.print("입금 계좌번호 > ");
        String depositAccount = sc.nextLine();
        int index = FindAccount(depositAccount);
        if(index == -1) {
            System.out.println("없는 계좌번호 입니다.");
            return;
        }
        System.out.print("예금액 > ");
        String temp = sc.nextLine();
        int money = StringToInt(temp);
        if(money <= 0 ) {
            System.out.println("입금은 0원 이상의 금액만 가능합니다.");
            return;
        }
        int nowBal = StringToInt(accounts[index].getInitBalance());
        int newBal = money + nowBal;

        accounts[index].setInitBalance(Integer.toString(newBal));
    }

    void Withdrawal() {
        System.out.println("---------");
        System.out.println("출금");
        System.out.println("---------");
        System.out.print("출금 계좌번호 > ");
        String depositAccount = sc.nextLine();
        int index = FindAccount(depositAccount);
        if(index == -1) {
            System.out.println("없는 계좌번호 입니다.");
            return;
        }
        System.out.print("출금액 > ");
        String money = sc.nextLine();
        String nowBal = accounts[index].getInitBalance();
        int newBal = Integer.parseInt(nowBal) - Integer.parseInt(money);
        if(newBal < 0 ) {
            System.out.println("계좌의 잔액이 부족합니다.");
            return;
        }
        accounts[index].setInitBalance(Integer.toString(newBal));
    }
}
