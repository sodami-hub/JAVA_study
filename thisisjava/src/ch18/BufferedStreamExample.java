
package ch18;

import java.io.*;
import java.util.Objects;

public class BufferedStreamExample {
    public static void main(String[] args) {
        try {
            String path = "\\Users\\leejinhun\\IdeaProjects\\JAVA_study\\thisisjava\\src\\ch18\\ReadWriteExample01.java";
            Reader reader = new FileReader(path);
            BufferedReader bis = new BufferedReader(reader);

            int lineNo =1 ;
            while(true) {
                String line = bis.readLine();
                if(line==null) break;
                System.out.println(lineNo +"\t"+line);
                lineNo++;
            }
            bis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
