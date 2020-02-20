package net.Http;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Response {
    private PrintWriter printWriter;
    private String version = "HTTP/1.1";
    private int status;
    private String message;
    private Map<String ,String> headers = new HashMap<>();
    private StringBuilder body = new StringBuilder();
    private Response(){

    }

    public void addHeaders(String key, String val) {
        headers.put(key, val);
    }

    public void println(String line) {
        body.append(line + "\n");
    }

    public void flush() {
        printWriter.println(version + " " + status + " " + message);
        printWriter.println("Content-Type: text/html; charset=UTF-8");
        if (body.length() != 0) {
            printWriter.println("Content-Length: " + body.toString().getBytes().length);
        }
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            printWriter.println(entry.getKey() + ": " + entry.getValue());
        }
        printWriter.println();
        if (body.length() != 0) {
            printWriter.println(body);
        }
    }
    public void build200(){
        status = 200;
        message = "OK";
    }

    public void build404() {
        status = 404;
        message = "Not Found";
    }

    public void build307() {
        status = 307;//301,302,307
        message = "Send Redirect";
    }
    public void build405() {
        status = 405;
        message = "Method Not Allowed";
    }
    public void build500() {
        status = 500;
        message = "Internal Server Error";
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Response buildResponse(OutputStream outputStream) {
        Response response = new Response();
        response.printWriter = new PrintWriter(outputStream, true);


        return response;
    }

}
