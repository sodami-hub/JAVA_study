package ch07_stringSearch._01_brute_force_method;

public class Main {
    public static void main(String[] args) {
        String txt = "ABCJEFGHIJKKL";
        String pattern = "JKK";
        BruteForceMethod bfm = new BruteForceMethod();
        int result = bfm.viewbfMethod(txt,pattern);
        System.out.println("result = " + result);
        
    }
}
