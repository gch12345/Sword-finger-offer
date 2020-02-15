package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/*
 TCP 面向字节流：可以获取到Socket对象中的输入输出字节流，而且可以在一个

 */
public class TCPServer {
    private static final int PORT = 9999;
    /**
     * 参数1：核心线程数（正式工，启动线程池就运行这个数量的线程）
     * 参数2：最大线程数（正式工+临时工）
     * 参数3+4：一定数量的时间+时间单位，在时间内，临时工的线程没有任务处理，就把临时工解雇掉（关闭线程）
     * 参数5：无边界的工作队列
     * 参数6：代表任务数量超出最大值， 线程池应该怎样做（4种策略）
      */
    private static final ThreadPoolExecutor POOL = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(), new ThreadPoolExecutor.CallerRunsPolicy());

    private static final ExecutorService EXE = Executors.newSingleThreadExecutor();
    public static void main(String[] args) throws IOException {
        //启动TCP服务器
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            //待新的客户端连接
            Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 获取到socket帮我们包装的一个输入字节流
                        InputStream is = socket.getInputStream();
                        // 缓冲字符流：字节流转换为字节流， 需要通过
                        // InputStreamReader 字节字符转换流来进行转换
                        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                        OutputStream os = socket.getOutputStream();
                        //BufferedWriter可以改造为PrintWriter（1.自动刷新 2.println可以不用手动输入换行符）
                        PrintWriter bw = new PrintWriter(os, true);
//                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println("服务端接收到数据：" + line);
                            bw.println("已经接收到了" + line + "消息");
//                            bw.write("已经接收到了" + line + "消息\n");
                            // 需要刷新一下缓冲区
//                            bw.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


//        while (true) {
//            // 阻塞， 等待新的客户端连接
//            Socket socket = serverSocket.accept();
//            // 获取到socket帮我们包装的一个输入字节流
//            InputStream is = socket.getInputStream();
//            // 缓冲字符流：字节流转换为字节流， 需要通过
//            // InputStreamReader 字节字符转换流来进行转换
//            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//            OutputStream os = socket.getOutputStream();
//            //BufferedWriter可以改造为PrintWriter（1.自动刷新 2.println可以不用手动输入换行符）
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println("服务端接收到数据：" + line);
//                bw.write("已经接收到了" + line + "消息\n");
//                // 需要刷新一下缓冲区
//                bw.flush();
//            }
//        }
    }
}