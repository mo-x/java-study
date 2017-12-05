package org.goskyer.base.staticserver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by zzqno on 2016-9-27.
 */
public class HttpServer {

    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    private boolean shutdown = false;


    public static void main(String[] args) {
        System.out.println(WEB_ROOT);
        System.out.println(" ==== 服务器启动 ===");
        new HttpServer().start();

    }

    /**
     * 开启服务器
     */
    public void start(){
        ServerSocket serverSocket = null;
        int  PORT = 8080;
        try {
            serverSocket = new ServerSocket(PORT, 1, InetAddress.getByName("127.0.0.1"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        // 利用shutdown 参数控制服务器忙等待 相当于自旋锁
        while (!shutdown){
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();

                // create Request object and parse
                Request request = new Request(input);
                request.parse();

                // create Response object
                Response response = new Response(output);
                response.setRequest(request);
                response.sendStaticResource();

                // Close the socket;
                socket.close();

                // check if the revious URI is a shutdown command
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            } catch (IOException e) {

                e.printStackTrace();
                continue;

            }
        }
    }
}
