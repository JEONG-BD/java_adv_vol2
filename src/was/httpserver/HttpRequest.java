package was.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.*;

public class HttpRequest {
    private String method;
    private String path;
    private final Map<String, String> queryParam = new HashMap<>();
    private final Map<String, String> headers = new HashMap<>();

    public HttpRequest(BufferedReader reader) throws IOException {
        parseRequestLine(reader);
        parseRequestHeader(reader);
    }

    private void parseRequestLine(BufferedReader reader) throws IOException {
        String requestLine = reader.readLine();
        if(requestLine == null){
            throw new IOException("EOF No request line received");
        }
        String[] parts = requestLine.split(" ");
        if(parts.length != 3){
            throw new IOException("Invalid request Line " + requestLine ) ;
        }

        method = parts[0];

        String[] pathParts = parts[1].split("\\?");
        path = pathParts[0];

        if(pathParts.length > 1){
            parseQueryParameters(pathParts[1]);
        }
    }

    private void parseQueryParameters(String queryStr) {

        for (String param : queryStr.split("&")) {
            String[] keyValue = param.split("=");
            String key = URLDecoder.decode(keyValue[0], UTF_8);
            String value = keyValue.length > 1? URLDecoder.decode(keyValue[1], UTF_8) : "";
             queryParam.put(key, value);
        }
    }

    private void parseRequestHeader(BufferedReader reader) throws IOException {
        String line;

        while (!(line = reader.readLine()).isEmpty()){
            String[] headerParts = line.split(":");
            headers.put(headerParts[0].trim(), headerParts[1].trim());
        }

    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getParameter(String name){
        return queryParam.get(name);
    }

    public String getHeader(String name){
        return headers.get(name);
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", queryParam=" + queryParam +
                ", headers=" + headers +
                '}';
    }
}
