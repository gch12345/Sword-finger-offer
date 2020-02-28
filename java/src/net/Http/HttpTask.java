package net.Http;

import java.io.*;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HttpTask implements Runnable {
    //private Socket socket;
    private Request request;
    private Response response;
    private static final String SESSION_KEY = "SESSIONID";
    private static ConcurrentHashMap<String, String> SESSIONS = new ConcurrentHashMap<>();
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
        try {
            if ("/".equals(request.getUrl())) {
                response.build200();
                response.println("<h2>Http服务器首页</h2>");
                return;
            }
            InputStream is =  this.getClass().getClassLoader().getResourceAsStream("." + request.getUrl());
            if (is != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                String con;
                while ((con = br.readLine()) != null) {
                    response.println(con);
                }
                response.build200();
            } else if ("/login".equals(request.getUrl())) {
                if (!"post".equalsIgnoreCase(request.getMethod())) {
                    response.build405();
                    response.println("不支持的请求方法：" + request.getMethod());
                } else {
                    response.build200();
                    response.println("请求的数据：name=" +
                            request.getParameter("name") + "password=" +
                            request.getParameter("password"));
                    String sessionsId = UUID.randomUUID().toString();
                    SESSIONS.put(sessionsId, request.getParameter("name") +
                            "," + request.getParameter("password"));
                    //response.addHeaders("SESSIONID", sessionsId);
                    response.addHeaders("Set-Cookie", SESSION_KEY  + "=" + sessionsId);
                }
            } else if ("/sensitive".equalsIgnoreCase(request.getUrl())) {
                String content = "<p>该用户没有登录<p>";
                String sessionInfo = request.getHeader("Cookie");
                if (sessionInfo != null && sessionInfo.trim().length() != 0) {
                    String[] cookieInfos = sessionInfo.split(";");
                    if (cookieInfos != null) {
                        for (String cookieInfo : cookieInfos) {
                            String[] cookieArray = cookieInfo.trim().split("=");
                            if (SESSION_KEY.equals(cookieArray[0])) {
                                String userInfo = SESSIONS.get(cookieArray[1]);
                                if (userInfo != null) {
                                    content = "获取到的用户信息" + userInfo;
                                    System.out.println(content);
                                }
                            }
                        }
                    }
                }
                response.build200();;
                response.println(content);
            } else {
                response.build404();
                response.println("找不到资源");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.build500();
            response.println("服务器出错");
        } finally {
            response.flush();
        }
    }
}
