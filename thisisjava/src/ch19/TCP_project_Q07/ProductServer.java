package ch19.TCP_project_Q07;

import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductServer {

    ServerSocket serverSocket;
    ExecutorService threadPool = Executors.newFixedThreadPool(10);
    List<Product> products = new ArrayList<>();

    // 서버에 접속하는 클라이언트의 객체
    public static class SocketClient {
        ProductServer productServer;
        Socket socket;
        DataInputStream dis;
        DataOutputStream dos;
        String clientIp;
        Product product;

        SocketClient(ProductServer server,Socket socket) {
            try {
                this.productServer = server;
                this.socket = socket;
                this.dis = new DataInputStream(socket.getInputStream());
                this.dos = new DataOutputStream(socket.getOutputStream());
                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                this.clientIp = isa.getHostName();
                product = new Product();
                receive();
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
        }

        public void receive() {
            productServer.threadPool.execute(()->{
                try {
                    while(true) {
                        String receiveJson=dis.readUTF();

                        JSONObject jsonObject = new JSONObject(receiveJson);
                        int command = jsonObject.getInt("command");
                        JSONObject object;
                        switch(command) {
                            case 0 :
                                productServer.addClient(clientIp);
                                productServer.sendToAll(this);
                                break;
                            case 1:
                                object = jsonObject.getJSONObject("data");
                                productServer.addProduct(object);
                                productServer.sendToAll(this);
                                break;
                            case 2:
                                object = jsonObject.getJSONObject("data");
                                productServer.updateProduct(object);
                                productServer.sendToAll(this);
                                break;
                            case 3:
                                int no = jsonObject.getInt("data");
                                productServer.removeProduct(no);
                                productServer.sendToAll(this);
                                break;
                            case 4 :
                                productServer.outClient(clientIp);
                                break;
                        }
                    }
                }catch(IOException e) {
                    System.out.println(e.getMessage());
                    productServer.outClient(clientIp);
                }
            });
        }

        public void send(String json) {
            try {
                dos.writeUTF(json);
                dos.flush();
            } catch(IOException e) {

            }
        }

        public void close() {
            try {
                System.out.println("접속 종료");
                productServer.outClient(clientIp);
                socket.close();
            }catch(IOException e) {

            }
        }
    }

    public void sendToAll(SocketClient client) {
        JSONObject object = new JSONObject();
        object.put("data",products);
        String json = object.toString();
        client.send(json);
    }


    public void serverStart() throws IOException {
        serverSocket = new ServerSocket(50001);
        System.out.println("서버 시작");

        Thread thread = new Thread(()-> {
            try {
                while(true) {
                    Socket socket = serverSocket.accept();
                    SocketClient sc = new SocketClient(this, socket);
                }
            } catch (IOException e){
            }
        });
        thread.start();
    }

    public void addClient(String Ip) {
        System.out.println("IP : "+Ip+"님이 서버에 접속했습니다.");
    }
    public void outClient(String Ip) {
        System.out.println("IP : "+Ip+"님이 서버에서 나갔습니다.");
    }

    public synchronized void addProduct(JSONObject object) {
        int len = products.size();
        Product p = new Product();
        p.setNo(len+1);
        p.setName(object.getString("name"));
        p.setPrice(object.getInt("price"));
        p.setStock(object.getInt("stock"));
        products.add(p);
        JSONObject sendObject = new JSONObject();
        sendObject.put("data",products);
    }

    public synchronized void updateProduct(JSONObject object) {

    }

    public synchronized void removeProduct(int no) {

    }



    public void serverStop() throws IOException {
        serverSocket.close();
        threadPool.shutdownNow();
        System.out.println("서버 종료");
    }

    public static void main(String[] args) {
        try {
            ProductServer productServer = new ProductServer();
            productServer.serverStart();

            System.out.println("------------------------------------------");
            System.out.println("서버를 종료하려면 q를 입력하세요.");
            System.out.println("------------------------------------------");

            Scanner sc = new Scanner(System.in);

            while (true) {
                String key = sc.nextLine();
                if (key.toLowerCase().equals("q")) break;
            }

            sc.close();
            productServer.serverStop();
        } catch(IOException e) {
            System.out.println("서버 :" + e.getMessage());
        }
    }


}
