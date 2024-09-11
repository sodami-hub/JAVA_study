package ch07_stringSearch._03_boyer_moore_method;

public class BMSearch {
    public int bmSearch(String txt, String pat) {
        int pt;
        int pp;
        int txtLen = txt.length();
        int patLen = pat.length();
        int[] skip = new int[Character.MAX_VALUE+1];

        for(int i = 0; i<= Character.MAX_VALUE; i++) {
            skip[i] = patLen;
        }
        for(int i =0; i<patLen-1; i++) {
            skip[pat.charAt(i)] = patLen-i-1;
        }

        pt = patLen-1; // 처음 검색 위치
        while(pt < txtLen) {
            pp = patLen-1;

            while(txt.charAt(pt) == pat.charAt(pp)) {
                if(pp==0) {
                    return pt;
                }
                pp--;
                pt--;
            }
            // 패턴의 맨 끝에서 부터 맞춰서 비교를 시작하고. 비교가 다르면 skip과 대조해서 pt를 이동.
            pt += (skip[txt.charAt(pt)] > patLen-pp) ? skip[txt.charAt(pt)]: patLen-pp;
        }
        return -1;
    }
}
