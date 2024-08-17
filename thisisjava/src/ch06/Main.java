package ch06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        //Example15-확인
//        System.out.println("--------- Ex15-------------------");
//        MemberService memberService = new MemberService();
//        boolean result = memberService.login("hong","12345");
//        if(result) {
//            System.out.println("log in successful.");
//        } else {
//            System.out.println("login failed.");
//        }
//
//        System.out.println("\n--------- Ex16,17-------------------");
//        //Example16 - 확인
//        Printer print = new Printer();
//        print.println(10);
//        print.println(true);
//        print.println(3.15);
//        print.println("홍길동");
//
//        //Example17 - 확인
////        Printer.println(10);
////        Printer.println(true);
////        Printer.println(3.14);
////        Printer.println("hong");
//
//        System.out.println("\n--------- Ex18-------------------");
//        //Example18 - 확인
//        ShopService obj1 = ShopService.getInstance();
//        ShopService obj2 = ShopService.getInstance();
//
//        if (obj1 == obj2) {
//            System.out.println("shop 1 and shop 2 are the same instance.");
//        } else {
//            System.out.println("shop 1 and shop 2 are the difference instance.");
//        }
//
//
//        System.out.println("\n--------- Ex19 -------------------");
//
//        Account account = new Account();
//
//        account.setBalance(10000);
//        System.out.println("현재 잔고 : " + account.getBalance() );
//
//        account.setBalance(-1000);
//        System.out.println("현재 잔고 : " + account.getBalance() );
//
//        account.setBalance(2000000);
//        System.out.println("현재 잔고 : " + account.getBalance() );
//
//        account.setBalance(200000);
//        System.out.println("현재 잔고 : " + account.getBalance() );

        System.out.println("\n--------- Ex20 -------------------");

        Scanner sc = new Scanner(System.in);

        BankApplication myApp = new BankApplication();

        String sel="";
        while(true) {

            if(sel.equals("5")) {
                System.out.println("Exit");
                break;
            }

            System.out.println("-------------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("-------------------------------------------------");
            System.out.print("선택> ");

            sel = sc.nextLine();

            switch(sel) {
                case "1":
                    myApp.CreateAccount();
                    break;
                case "2":
                    myApp.AccountList();
                    break;
                case "3":
                    myApp.Deposit();
                    break;
                case "4":
                    myApp.Withdrawal();
                    break;
                case "5":
                    break;

            }
        }


    }
}
