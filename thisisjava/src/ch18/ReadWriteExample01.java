package ch18;

import java.io.*;

public class ReadWriteExample01 {

    // 바이트 단위 입출력 스트림을 이용한 파일 생성 및 복사
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("C:/Users/leejinhun/Downloads/test.txt");

            byte[] writeArr = {10, 20, 30, 40, 50};
            os.write(writeArr);

            os.flush();
            os.close();

            System.out.println("파일이 생성되었습니다.");

            byte[] readArr = new byte[100];

            InputStream is = new FileInputStream("C:/Users/leejinhun/Downloads/test.txt");
            int res;
            while (true) {
                res = is.read(readArr);  // 읽은 바이트 수 만큼 반환
                if (res == -1) break;
                System.out.println("읽은 바이트 수: " + res);
                for (int i = 0; i < res; i++) {
                    System.out.println(readArr[i]);
                }
            }
            System.out.println("읽은 바이트 수: " + res);


            is.close();

        }catch(FileNotFoundException e) {
                e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
