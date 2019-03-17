package org.goskyer.base.socket.tcp;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by zzqno on 2017-3-7.
 * 客户端
 */
public class Client {

    public static void main(String[] args) {
        try {
            //1.创建客户端Socket，指定服务器地址和端口
            Socket socket = new Socket("localhost", 9999);
            //2.获取输出流，向服务器端发送信息
            //字节输出流
            OutputStream os = socket.getOutputStream();
            //将输出流包装为打印流
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名：alice;密码：789");
            pw.flush();
            socket.shutdownOutput();//关闭输出流
            //3.获取输入流，并读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info;
            while ((info = br.readLine()) != null) {
                System.out.println("我是客户端，服务器说：" + info);
            }
            //4.关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
