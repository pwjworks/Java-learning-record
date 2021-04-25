package site.pwjworks.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realPath = "D:\\java-environment\\apache-tomcat-10.0.5\\webapps\\response_war\\WEB-INF\\classes\\1.png";
        System.out.println("real path:" + realPath);
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        FileInputStream in = new FileInputStream(realPath);
        int len = 0;
        byte[] buf = new byte[1024];
        ServletOutputStream out = resp.getOutputStream();
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
