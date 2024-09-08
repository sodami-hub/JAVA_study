package ch07_stringSearch._01_brute_force_method;

public class Main {
    public static void main(String[] args) {
        String txt = "abc안녕ABC";
        String pattern = "안녕";
        BruteForceMethod bfm = new BruteForceMethod();
        int result = bfm.bfMethod(txt,pattern);
        System.out.println("result = " + result);
        
    }
}
