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
