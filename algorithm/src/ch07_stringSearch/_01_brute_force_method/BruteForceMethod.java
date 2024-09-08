package ch07_stringSearch._01_brute_force_method;

public class BruteForceMethod {
    public int bfMethod(String txt, String pat) {
        int matchPoint=0;
        int index=-1;
        int txtCur;
        for(int i = 0;i<txt.length();i++) {
            if(matchPoint==pat.length()) break;

            txtCur = i;
            matchPoint=0;
            for(int j =0;j<pat.length();j++) {
                if(pat.charAt(j) == txt.charAt(txtCur)) {
                    txtCur++;
                    matchPoint++;
                    if(matchPoint==pat.length()) {
                        index = i;
                    }
                }else {
                    break;
                }
            }
        }
        return index;
    }

    public int viewbfMethod(String txt, String pat) {
        int matchPoint=0;
        int index=-1;
        int compareCount = 0;
        int txtCur;
        for(int i = 0;i<txt.length();i++) {
            txtCur = i;
            if(matchPoint==pat.length()) break;
            matchPoint=0;
            System.out.println(i+" "+txt);
            System.out.print("  ");
            for(int k=0; k<i;k++) {
                System.out.print(" ");
            }

            for(int j =0;j<pat.length();j++) {
                if(j>=1) {
                    System.out.println("  "+txt);
                    System.out.print("  ");
                    for(int k=0; k<i+j;k++) {
                        System.out.print(" ");
                    }
                }
                if(pat.charAt(j) == txt.charAt(txtCur)) {
                    System.out.println("+");
                    System.out.print("  ");
                    for(int k=0; k<i;k++) {
                        System.out.print(" ");
                    }
                    System.out.println(pat);

                    txtCur++;
                    matchPoint++;
                    compareCount++;
                    if(matchPoint==pat.length()) {
                        index = i;
                    }
                }else{
                    System.out.println("|");
                    System.out.print("  ");
                    for(int k=0; k<i;k++) {
                        System.out.print(" ");
                    }
                    System.out.println(pat);
                    compareCount++;
                    break;
                }
            }
        }
        System.out.println("비교횟수는 "+compareCount+"회 입니다.");
        return index;
    }
}
