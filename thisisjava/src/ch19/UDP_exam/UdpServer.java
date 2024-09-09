package ch19.UDP_exam;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;

public class UdpServer {
    private static DatagramSocket datagramSocket = null;

    public static void main(String[] args) throws Exception{
        System.out.println("----------------------------------------------");
        System.out.println("서버를 종료하려면 q를 입력하고 Enter를 입력하세요.");
        System.out.println("----------------------------------------------");

        //UDP서버시작
        startServer();

        Scanner sc = new Scanner(System.in);
        while(true) {
            String key = sc.nextLine();
            if(key.toLowerCase().equals("q")) {
                break;
            }
        }
        sc.close();

        stopServer();
    }

    public static void startServer() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    //DatagramSocket 생싱 및 port 바인딩
                    datagramSocket = new DatagramSocket(50001);
                    System.out.println("서버 시작");


                    while(true) {
                        //데이터 받기
                        DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
                        datagramSocket.receive(receivePacket);
                        String newsKind = new String(receivePacket.getData(),0,receivePacket.getLength(),"UTF-8");
                        System.out.println("클라이언트로 부터 받은 메세지 : "+newsKind);

                        // 클라이언트의 IP와 port 번호 얻기
                        SocketAddress socketAddress = receivePacket.getSocketAddress();

                        // 클라이어트로 응답
                        for(int i =1; i<=10; i++) {
                            String data = newsKind +" : 뉴스" + i;
                            byte[] bytes = data.getBytes("UTF-8");
                            DatagramPacket sendPacket = new DatagramPacket(bytes, 0,bytes.length,socketAddress);
                            datagramSocket.send(sendPacket);
                        }
                    }
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public static void stopServer() {
        // datagramSocket을 닫고 port 언바인딩
        datagramSocket.close();
        System.out.println("서버 종료됨");
    }
}
