package ch19.JSON_exam;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class ParseJsonExample {
    public static void main(String[] args) throws IOException {

        // file에서 json 읽어오기
        BufferedReader br = new BufferedReader(new FileReader("/Users/leejinhun/Downloads/newJson.json", Charset.forName("UTF-8")));
        String json = br.readLine();
        br.close();

        // json 파싱
        JSONObject root = new JSONObject(json);

        // 속성 정보 읽기
        System.out.println("id : " + root.getString("id"));
        System.out.println("name : " + root.getString("name"));
        System.out.println("age : " + root.getInt("age"));
        System.out.println("student : " + root.getBoolean("student"));

        // 객체 속성 정보 읽기
        JSONObject tel = root.getJSONObject("tel");

        System.out.println("home : " + tel.getString("home"));
        System.out.println("mobile : " + tel.getString("mobile"));

        JSONArray skill = root.getJSONArray("skill");

        System.out.print("skill : ");
        for (Object sk : skill) {
            System.out.print(sk+", ");
        }


    }
}
