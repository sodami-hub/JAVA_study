package ch18;

import java.io.*;


//문자 입출력
public class CharacterStreamExample {
    public static void main(String[] args) {
        try {
            Writer write;
            write = new FileWriter("\\Users\\leejinhun\\Downloads\\test.txt");
            String str = "text test";

            write.write(str);
            write.flush();
            write.close();

            Reader reader;
            reader = new FileReader("\\Users\\leejinhun\\Downloads\\test.txt");
            char[] res = new char[40];
            while(true) {
                int result = reader.read(res);
                if(result == -1) break;
                for(int i = 0; i < result; i++) {
                    System.out.print(res[i]);
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
