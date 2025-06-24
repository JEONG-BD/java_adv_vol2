package was.httpserver;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class HttpResponse {
    private final PrintWriter writer;
    private int statusCode = 200;
    private final StringBuilder bodyBuilder = new StringBuilder();
    private String contentType = "text/html; charset=UTF-8" ;

    public HttpResponse(PrintWriter writer) {
        this.writer = writer;
    }

    public int setStatusCode(int statusCode) {
        return statusCode = statusCode;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void writeBody(String body){
        bodyBuilder.append(body);
    }

    public void flush(){
        int length = bodyBuilder.toString().getBytes(StandardCharsets.UTF_8).length;
        writer.println("HTTP/1.1 " + statusCode + " "+  getResponsePhrase(statusCode));
        writer.println("Content-Type: " + contentType);
        writer.println("Content-Length: " + length);
        writer.println();
        writer.println(bodyBuilder);
        writer.flush();
    }

    private String getResponsePhrase(int statusCode){
        switch (statusCode){
            case 200:
                return "OK";
            case 404:
                return "Not Found";
            case 500:
                return "Internal Server Error";
            default:
                return "Unknown Status";
        }

    }


}
