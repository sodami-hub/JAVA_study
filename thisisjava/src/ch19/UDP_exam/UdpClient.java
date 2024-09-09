package ch19.UDP_exam;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpClient {
    public static void main(String[] args) {
        try {
            //datagram socket 생성
            DatagramSocket datagramSocket = new DatagramSocket();

            // 서버에 데이터 보내기
            String data = "정치";
            byte[] bytes = data.getBytes("UTF-8");
            DatagramPacket sendPacket = new DatagramPacket(bytes,bytes.length,new InetSocketAddress("localhost",50001));
            datagramSocket.send(sendPacket);

            while(true) {
                // 서버로 부터 데이터 받기
                DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
                datagramSocket.receive(receivePacket);

                // 문자열로 전환해서 출력
                String news = new String(receivePacket.getData(),0,receivePacket.getLength(),"UTF-8");
                System.out.println(news);

                if(news.contains("뉴스10")) {
                    break;
                }
            }
            datagramSocket.close();
            System.out.println("클라이언트가 종료됨");

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
