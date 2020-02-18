package net.TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    //本机默认的域名是localhost, 默认的IP是127.0.0.1
//    private static final String HOST = "localhost";
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 9999;
    public static void main(String[] args) throws IOException {
        // 建立了客户端连接对象
        Socket socket = new Socket(HOST, PORT);
        InputStream is = socket.getInputStream();
        // 缓冲字符流：字节流转换为字节流， 需要通过
        // InputStreamReader 字节字符转换流来进行转换
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);
//        pw.println("holle");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            //已经去除了换行符
            String line = scanner.nextLine();
            //println会发送数据会加上换行符
            //发送数据报到服务端
            pw.println(line);
            //接受服务端的响应消息
            System.out.println(br.readLine());
        }
    }
}
