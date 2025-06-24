package was.httpserver.servlet;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.HttpServlet;
import was.httpserver.PageNotFoundException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServletManager {
    private final Map<String, HttpServlet> servletMap = new HashMap<>();
    private HttpServlet defaultServlet;
    private HttpServlet notFoundServlet = new NotFoundServlet();
    private HttpServlet internalErrorServlet = new NotFoundServlet();

    public ServletManager() {
    }

    public void add(String path, HttpServlet servlet){
        servletMap.put(path, servlet);
    }

    public void setDefaultServlet(HttpServlet defaultServlet) {
        this.defaultServlet = defaultServlet;
    }

    public void setNotFoundServlet(HttpServlet notFoundServlet) {
        this.notFoundServlet = notFoundServlet;
    }

    public void setInternalErrorServlet(HttpServlet internalErrorSerlet) {
        this.internalErrorServlet = internalErrorSerlet;
    }

    public void execute(HttpRequest request, HttpResponse response) throws IOException {
        try {
            HttpServlet servlet = servletMap.getOrDefault(request.getPath(), defaultServlet);

            if(servlet == null){
                throw  new PageNotFoundException(" request url = " + request.getPath());
            }
            servlet.service(request, response);

        } catch (PageNotFoundException e){
            e.printStackTrace();
            notFoundServlet.service(request, response);
        } catch (Exception e){
            internalErrorServlet.service(request, response);
        }
    }
}
