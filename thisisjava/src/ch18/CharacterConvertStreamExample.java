package ch18;

import java.io.*;

// 보조 스트림 Writer, Reader 클래스를 사용해서 문자를 바로 쓰고 읽기.
public class CharacterConvertStreamExample {

    public static void main(String[] args) {
        write("문자 변환 스트림을 사용합니다.");
        String res = read();
        System.out.println("res = " + res);
    }

    public static void write(String str) {
        try {
            OutputStream os = new FileOutputStream("C:/Users/leejinhun/Downloads/test.txt");
            Writer writer = new OutputStreamWriter(os, "UTF-8");

            writer.write(str);
            writer.flush();
            writer.close();

            System.out.println("파일이 생성되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String read() {
        try {
            InputStream is = new FileInputStream("C:/Users/leejinhun/Downloads/test.txt");
            Reader reader = new InputStreamReader(is, "UTF-8");
            char[] buffer = new char[100];
            int res = reader.read(buffer);
            reader.close();
            return new String(buffer, 0, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
