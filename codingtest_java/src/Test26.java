public class Test26 {

    public static int solution(int n, int a, int b) {
        int result=0;
        int[] persons = new int[n+1];
        for(result =0; a != b; result++ ) {
            a= (a+1)/2;
            b= (b+1)/2;
            System.out.println("a : "+a+" | b : "+b);
        }

        return result;
    }


    public static void main(String[] args) {
        int N,A,B,answer;
        N=8;
        A=4;
        B=7;
        answer=solution(N,A,B);
        System.out.println("answer = " + answer);
    }
}

