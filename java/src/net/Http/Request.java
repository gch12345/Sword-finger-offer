package net.Http;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private String method;
    private String url;
    private String version;
    private Map<String ,String> headers = new HashMap<>();
    private Map<String, String> parameters = new HashMap<>();

    private Request() {

    }

    public static Request buildRequest(InputStream inputStream) throws IOException {
        Request request = new Request();
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8")
            );
            System.out.println("===========解析http请求===========");
            String requestLine = input.readLine();
            request.parseRequestLine(requestLine);
            String header;
            while ((header = input.readLine()) != null && header.length() != 0) {
                String[] parts = header.split(":");
                request.headers.put(parts[0].trim(), parts[1].trim());
                System.out.printf("请求头：%s = %s", parts[0].trim(), parts[1].trim());
                System.out.println();
            }
            if ("POST".equalsIgnoreCase(request.method)
                    && request.headers.containsKey("Content-Length")) {
                int len = Integer.parseInt(request.headers.get("Content-Length"));
                char[] chars = new char[len];
                input.read(chars, 0, len);
                request.parseParameters(new String(chars));
            }
            System.out.print("请求参数：");
            for (Map.Entry<String, String> entry : request.parameters.entrySet()) {
                System.out.printf("%s = %s，", entry.getKey(), entry.getValue());
            }
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException("处理请求数据错误", e);
        }
        return request;
    }

    private void parseRequestLine(String requestLine) {
        String[] parts = requestLine.split(" ");
        method = parts[0];
        url = parts[1];
        int index = url.indexOf("?");
        if (index != -1) {
            parseParameters(url.substring(index + 1));
            url = url.substring(0, index);
        }
        version = parts[2];
        System.out.printf("请求方法：%s，url：%s，版本号：%s", method, url, version);
    }
    private void parseParameters(String parameters) {
        String[] parts = parameters.split("&");
        if (parts != null && parts.length != 0) {
            for (String x : parts) {
                String[] part = x.split("=");
                this.parameters.put(part[0], part[1]);
            }
        }
    }
}
