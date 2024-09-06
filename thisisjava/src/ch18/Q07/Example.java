package ch18.Q07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Example {
    public static void main(String[] args) throws IOException {
        String filePath = "\\Users\\leejinhun\\Downloads/VariableExchangeExample.java";

        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        int lineNo = 1;
        String line="";

        while(true) {
            line = br.readLine();
            if(line == null) {
                break;
            }
            System.out.println(lineNo +"\t" +line);
            lineNo++;
        }

        br.close();
    }
}
