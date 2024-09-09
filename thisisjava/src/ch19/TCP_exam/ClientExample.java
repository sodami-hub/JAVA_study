package ch19.TCP_exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {
    public static void main(String[] args) {
        try{
            //Socket 생성과 동시에 localhost의 50001포트로 연결 요청
            Socket socket = new Socket("localhost",50001);

            System.out.println("클라이언트 연결 성공");

            // -------------------- 데이터 보내기 ------------------
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String msg = "데이터를 보낸다.";
            dos.writeUTF(msg);
            dos.flush();

            // =---------------------- 데이터 받기 ------------------
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String receiveMsg = dis.readUTF();
            System.out.println("서버로 부터 받은 데이터 : "+ receiveMsg);

            //----------------------------------------------------

            socket.close();
            System.out.println("클라이언트 연결 해제");
        } catch(UnknownHostException e) {

        } catch(IOException e) {

        }
    }
}
