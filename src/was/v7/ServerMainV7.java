package was.v7;

import was.httpserver.HttpServer;
import was.httpserver.annotation.AnnotationServletV1;
import was.httpserver.servlet.ServletManager;
import was.v6.SiteControllerV6;

import java.io.IOException;
import java.util.List;

public class ServerMainV7 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        List<Object> controllers = List.of(new SiteControllerV7(), new SiteControllerV6());
        AnnotationServletV1 annotationServlet = new AnnotationServletV1(controllers);

        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(annotationServlet);
        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();

    }
}
