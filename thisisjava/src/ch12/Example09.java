package ch12;

public class Example09 {
    public static void main(String[] args) throws Exception{
        byte[] bytes = {-20, -107, -120, -21, -123, -107};
        String str = new String(bytes);
        System.out.println("bytes to str :" +str);
    }
}
