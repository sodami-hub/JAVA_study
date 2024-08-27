package ch03_searchAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q07 {
    //--- 신체검사 데이터 ---//
    static class PhyscData {
        private String name;          // 이름
        private int    height;        // 키
        private double vision;        // 시력

        //--- 생성자(constructor) ---//
        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return name +" "+height+" "+vision;
        }

        public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();

        private static class VisionOrderComparator implements Comparator<PhyscData> {

            @Override
            public int compare(PhyscData d1, PhyscData d2) {
                if(d1.vision > d2.vision) {
                    return -1;
                } else if(d1.vision < d2.vision) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        PhyscData[] x = {                    // 키의 오름차순으로 정렬
                new PhyscData("박준서", 175, 2.0),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("장경오", 174, 1.2),
                new PhyscData("황지안", 169, 0.8),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("이수연", 168, 0.4),
                new PhyscData("강민하", 162, 0.3),
        };
        System.out.print("시력이 x인 사람을 찾고 있나요?: ");
        double vision = stdIn.nextDouble();                // 킷값을 읽어 들임

        int idx = Arrays.binarySearch(x, new PhyscData("",0, vision), PhyscData.VISION_ORDER);

        if (idx < 0)
            System.out.println("그 값의 요소가 없습니다.");
        else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터: " + x[idx]);
        }
    }

}
