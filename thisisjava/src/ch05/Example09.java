package ch05;

import java.util.Scanner;

public class Example09 {
    public static void main(String[] args) {
        int selectnum=0;
        int studentNum=0;
        int[] scores = new int[10];
        int sum=0;
        double avg = 0.0;
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("----------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3. 점수리스트 | 4.분석 | 5.종료");
            System.out.println("----------------------------------------------------");
            System.out.print("선택> ");
            selectnum = sc.nextInt();

            switch(selectnum) {
                case 1:
                    System.out.print("학생수> ");
                    studentNum = sc.nextInt();
                    break;
                case 2:
                    if(studentNum == 0){
                        System.out.println("먼저 학생수를 입력하세요.");
                        continue;
                    }
                    for(int i=0; i<studentNum; i++){
                        System.out.print("scores["+i+"] >");
                        scores[i] = sc.nextInt();
                    }
                    break;
                case 3:
                    if(studentNum == 0){
                        System.out.println("먼저 학생수와 점수를 입력하세요.");
                        continue;
                    }
                    System.out.print("학생들의 점수 : ");
                    for(int i=0; i<studentNum; i++) {
                        System.out.print(scores[i]+" ");
                    }
                    System.out.println();
                    break;
                case 4:
                    if(studentNum == 0){
                        System.out.println("먼저 학생수와 점수를 입력하세요.");
                        continue;
                    }
                    int max = scores[0];
                    int total =0;
                    total += scores[0];
                    for(int i = 1; i<studentNum; i++) {
                        total += scores[i];
                        if(max < scores[i]) {
                            max = scores[i];
                        }
                    }
                    System.out.println("최고점수 : "+max);
                    System.out.println("평균 : "+total/(double)studentNum);
                    break;
                case 5:
                    System.out.println("프로그램 종료");
                    sc.close();
                    return;
                default:
                    System.out.println("1~5의 수를 입력하세요.");
                    break;
            }
        }
    }
}
