package was.v5;

import was.httpserver.HttpServer;
import was.httpserver.servlet.DiscardServlet;
import was.httpserver.servlet.ServletManager;
import was.v5.servlet.HomeServlet;
import was.v5.servlet.SearchServlet;
import was.v5.servlet.Site1Servlet;
import was.v5.servlet.Site2Servlet;

import java.io.IOException;

public class ServerMainV5 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServletManager servletManager = new ServletManager();
        servletManager.add("/", new HomeServlet());
        servletManager.add("/site1", new Site1Servlet());
        servletManager.add("/site2", new Site2Servlet());
        servletManager.add("/search", new SearchServlet());
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer httpServer = new HttpServer(PORT, servletManager);
        httpServer.start();
    }
}
