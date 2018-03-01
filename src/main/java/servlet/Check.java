package servlet;

import dao.Logindao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Check extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user=req.getParameter("username");
        String pwd=req.getParameter("password");
        Logindao dao=new Logindao();
        boolean flag=dao.checkInfo(user,pwd);
        ServletContext application=this.getServletContext();
        RequestDispatcher dispatcher;
        if(flag){//登录成功
            dispatcher=application.getRequestDispatcher("/login_success.html");
        }else{
            dispatcher=application.getRequestDispatcher("/login_fail.html");
        }
        dispatcher.forward(req,resp);
    }
}
