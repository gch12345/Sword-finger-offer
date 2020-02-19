package net.Http;

import java.io.IOException;
import java.net.Socket;

public class HttpTask implements Runnable {
    //private Socket socket;
    private Request request;
    private Response response;
    public HttpTask(Socket socket) {
//        this.socket = socket;
        try {
            request = Request.buildRequest(socket.getInputStream());
            response = Response.buildResponse(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("客户端连接的IO流出错", e);
        }
    }
    @Override
    public void run() {
        response.setStatus(200);
        response.setMessage("OK");
        response.println("正确响应了客户端信息");
        response.flush();
    }
}
