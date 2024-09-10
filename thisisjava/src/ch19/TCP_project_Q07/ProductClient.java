package ch19.TCP_project_Q07;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ProductClient {
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    Product product;


    public void connect() throws IOException {
        socket = new Socket("localhost",50001);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        product = new Product();

        System.out.println("서버와 연결됨");
    }

    public void receive() {
        try {
            String json=dis.readUTF();
            JSONObject root = new JSONObject(json);

            JSONArray products = root.getJSONArray("data");
            if(products.length() == 0) {
                return;
            } else {
                System.out.println("-----------------------------------------------------------------");
                System.out.println("no  name       price     stock");
                System.out.println("-----------------------------------------------------------------");
                for(int i=0;i<products.length();i++) {
                    JSONObject object = products.getJSONObject(i);
                    System.out.println(object.getInt("no") + "    " + object.getString("name") + "          " + object.getInt("price") + "        " + object.getInt("stock"));
                }
            }
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void send(String json) {
        try {
            dos.writeUTF(json);
            dos.flush();
        } catch(IOException e){

        }
    }

    public void disconnect(){
        try {
            socket.close();
        } catch (IOException e) {
        }
    }


    public static void main(String[] args) {
        try {
            ProductClient client = new ProductClient();
            client.connect();


            JSONObject object = new JSONObject();
            object.put("command", 0);
            object.put("data", "");
            String json = object.toString();
            client.send(json);
            Scanner sc = new Scanner(System.in);
            int select = 0;


            while (true) {
                if (select == 4) client.disconnect();

                client.receive();

                System.out.println("메뉴: 1.Create | 2.Update | 3.Delete | 4.Exit");
                System.out.print("선택 > ");
                String sendData;
                select = sc.nextInt();

                switch (select) {
                    case 1:
                        object.put("command", 1);
                        System.out.println("[상품생성]");
                        System.out.print("상품 이름 : ");
                        String name = sc.next();
                        System.out.print("상품 가격 : ");
                        int price = sc.nextInt();
                        System.out.print("상품 재고 :");
                        int stock = sc.nextInt();
                        JSONObject newProduct = new JSONObject();
                        newProduct.put("name", name);
                        newProduct.put("price", price);
                        newProduct.put("stock", stock);
                        object.put("data", newProduct);
                        sendData = object.toString();
                        client.send(sendData);
                        break;
                    case 2:
                        object.put("command", 2);
                        break;
                    case 3:
                        object.put("command", 3);
                        break;
                    case 4:
                        object.put("command", 4);
                        sendData = object.toString();
                        client.send(sendData);
                        System.out.println("접속 종료");
                        break;
                }
            }
        }catch(IOException e){
            System.out.println("서버와의 접속 종료");
        }
    }
}
