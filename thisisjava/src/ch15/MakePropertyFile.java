package ch15;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// property 파일 생성 및 읽기. 예제 파일

public class MakePropertyFile {
    private final static String PATH = System.getProperty("user.dir") +"\\thisisjava\\src\\ch15\\sample.properties";
    private Properties properties;

    public MakePropertyFile() throws IOException {
        properties = new Properties();
        createFile();
    }

    public Properties getProperties() {
        return properties;
    }

    private void loadProperties() throws IOException {
        FileInputStream fis = new FileInputStream(PATH);
        properties.load(new BufferedInputStream(fis));
        fis.close();
    }

    private void createFile() throws IOException {
        File file = new File(PATH);
        if(!file.exists()) {
            file.createNewFile();
        }
    }

    public static void main(String[] args) throws IOException {
        // 프로퍼티 클래스 생성하며 프로퍼티 파일 생성
        MakePropertyFile makePropertyFile = new MakePropertyFile();
        // 프로퍼티 파일 읽기
        makePropertyFile.loadProperties();

        Properties properties = makePropertyFile.getProperties();
        for (int i = 0; i < 10; i++) {
            properties.setProperty("KEY" + i, "키값" + i);
        }

        String msg = properties.getProperty("KEY3");

        properties.list(System.out); // 프로퍼티 값 출력
        System.out.println("Key3 포함여부 =>> " + properties.containsKey("KEY3"));
        System.out.println("키값2 포함여부 =>> " + properties.containsValue("키값2"));
        System.out.println("Result =>> " + msg);
    }

}
