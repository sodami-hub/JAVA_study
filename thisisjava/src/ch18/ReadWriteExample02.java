package ch18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// 이미지 파일을 inputstream으로 읽어서 outputstream으로 복사
public class ReadWriteExample02 {
    public static void main(String[] args) {
        String src = "C:/Users/leejinhun/Downloads/test.jfif";
        String dest = "C:/Users/leejinhun/Downloads/copy.jfif";
        try {
            byte[] buffer = new byte[1024];

            InputStream is = new FileInputStream(src);
            OutputStream os = new FileOutputStream(dest);

            // 아래 while문은 파일을 복사하는 코드 -> is.transferTo(os)로 대체 가능
            while(true) {
                int res = is.read(buffer);
                if(res==-1) break;

                os.write(buffer,0,res);
            }

            is.close();
            os.flush();
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
