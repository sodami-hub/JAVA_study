package ch07_stringSearch._01_brute_force_method;

public class BruteForceMethod {
    public int bfMethod(String txt, String pat) {
        int matchPoint;
        int index=-1;
        int txtCur;
        for(int i = 0;i<txt.length();i++) {
            txtCur = i;
            matchPoint=0;
            for(int j =0;j<pat.length();j++) {
                if(pat.charAt(j) == txt.charAt(txtCur)) {
                    txtCur++;
                    matchPoint++;
                    if(matchPoint==pat.length()) {
                        index = i;
                    }
                }
            }
        }
        return index;
    }
}
