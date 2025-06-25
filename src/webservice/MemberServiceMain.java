package webservice;

import io.member.MemberRepository;
import io.member.impl.FileMemberRepository;
import was.httpserver.HttpServer;
import was.httpserver.HttpServlet;
import was.httpserver.annotation.AnnotationServletV3;
import was.httpserver.servlet.DiscardServlet;
import was.httpserver.servlet.ServletManager;

import java.io.IOException;
import java.util.List;

public class MemberServiceMain {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        MemberRepository memberRepository = new FileMemberRepository();
        MemController memController = new MemController(memberRepository);
        AnnotationServletV3 servlet = new AnnotationServletV3(List.of(memController));
        ServletManager servletManager = new ServletManager();
        servletManager.add("/favicon.ico", new DiscardServlet());
        servletManager.setDefaultServlet(servlet);
        HttpServer httpServer = new HttpServer(PORT, servletManager);
        httpServer.start();
    }
}
