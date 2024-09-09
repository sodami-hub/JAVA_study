package ch19.TCP_exam;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
    public static void main(String[] args) {
        try{
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("local.getHostAddress() = " + local.getHostAddress());

            InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
            for(InetAddress remote :iaArr ) {
                System.out.println("www.nvaer.com IP 주소 : " +remote.getHostAddress());
            }
        }catch(UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
