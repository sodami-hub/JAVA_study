package ch05_recursive;

// 배열의 최대공약수 구하기.
public class Q3 {
    public static int gcdArray(int[] a) {


        while(true) {

            int count = 0;
            int result=0;

            for(int i=0; i<a.length; i++) {
                if(a[i]!=0) {
                    if(result==0) {
                        result = a[i];
                    } else if(result != 0 && a[i] < result) {
                        result = a[i];
                    }
                }
            }

            for(int i=0; i<a.length; i++) {
                a[i] = a[i]%result;
            }

            for(int i : a) {
                if(i!=0) count+=1;
            }

            if(count == 0) return result;

        }

    }

    public static void main(String[] args) {
        int result = gcdArray(new int[] {10,8,4});
        System.out.println("result = " + result);
    }
}
