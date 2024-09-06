package ch18.Q10;

import java.io.*;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("원본 파일 경로 > ");
        String originPath = sc.nextLine();
        File file = new File(originPath);
        if(file.exists()==false) {
            System.out.println("원본 파일이 존재하지 않습니다.");
            return;
        }


        System.out.print("복사 파일 경로 > ");
        String targetPath = sc.nextLine();
        int index=0;
        for(int i = targetPath.length()-1; i>=0; i--) {
            if(targetPath.charAt(i) == '/' || targetPath.charAt(i) == '\\') {
                index =i;
                break;
            }
        }
        String dirPath = targetPath.substring(0,index+1);
        File targetDir = new File(dirPath);
        if(targetDir.exists()==false) {
            targetDir.mkdirs();
        }

        InputStream is = new FileInputStream(originPath);
        BufferedInputStream bis = new BufferedInputStream(is);

        OutputStream os = new FileOutputStream(targetPath);
        BufferedOutputStream bos = new BufferedOutputStream(os);

        bis.transferTo(bos);

        bis.close();
        bos.flush();
        bos.close();





    }
}
