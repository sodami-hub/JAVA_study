package ch19.TCP_project_Q07;

import org.json.JSONArray;
import org.json.JSONObject;

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
                System.out.println("[상품 목록]");
                System.out.println("-----------------------------------------------------------------");
                System.out.println("no  name       price     stock");
                System.out.println("-----------------------------------------------------------------");
                for(int i=0;i<products.length();i++) {
                    JSONObject object = products.getJSONObject(i);
                    System.out.println(object.getInt("no") + "    " + object.getString("name") + "          " + object.getInt("price") + "        " + object.getInt("stock"));
                }
                System.out.println("-----------------------------------------------------------------");
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

                int no;
                String name;
                int price;
                int stock;

                switch (select) {
                    case 1:
                        object.put("command", 1);
                        System.out.println("[상품생성]");
                        System.out.print("상품 이름 : ");
                        name = sc.next();
                        System.out.print("상품 가격 : ");
                        price = sc.nextInt();
                        System.out.print("상품 재고 :");
                        stock = sc.nextInt();
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
                        System.out.println("[상품 수정]");
                        System.out.print("상품 번호");
                        no = sc.nextInt();
                        System.out.println("이름 변경");
                        name = sc.next();
                        System.out.println("가격 변경");
                        price = sc.nextInt();
                        System.out.println("재고 변경");
                        stock = sc.nextInt();
                        JSONObject updateProduct = new JSONObject();
                        updateProduct.put("no",no);
                        updateProduct.put("name",name);
                        updateProduct.put("price",price);
                        updateProduct.put("stock",stock);
                        object.put("data",updateProduct);
                        sendData = object.toString();
                        client.send(sendData);
                        break;
                    case 3:
                        object.put("command", 3);
                        System.out.println("[상품 삭제]");
                        System.out.print("상품 번호 ");
                        no = sc.nextInt();
                        object.put("data", no);
                        sendData = object.toString();
                        client.send(sendData);
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
