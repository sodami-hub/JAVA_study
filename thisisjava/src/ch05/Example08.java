package ch05;

public class Example08 {
    public static void main(String[] args) {
        int[][] array = {
                {95, 86},
                {83, 92 ,98},
                {78, 83, 93, 87,88}
        };

        int[] sum={0,0,0};  // 각반의 총점을 넣을 배열
        double[] avg ={0,0,0}; // 각반의 평균을 넣을 배열
        for(int i=0; i<array.length; i++) {
            for(int j=0; j<array[i].length; j++) {
                sum[i] += array[i][j];
            }
        }

        // 전체 총합을 구하고 출력
        int totalsum=0; // 전체 총합을 넣을 변수
        for(int i: sum) {
            totalsum += i;
        }
        System.out.println("총합 : "+totalsum);

        // 각 반의 평균을 구하고 출력
        for(int i=0; i<array.length; i++) {
            avg[i] = sum[i]/(double)array[i].length;
        }
        System.out.print("각반의 평균 : ");
        for(double i: avg){
            System.out.print(i+" ");
        }

        // 전체 평균을 구하고 출력
        double totalavg=0;
        for(double i: avg) {
            totalavg += i;
        }
        System.out.println("\n전체 평균 : "+ totalavg/avg.length);

    }
}
