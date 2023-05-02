package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class JoinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/join.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        String userPwRe = request.getParameter("userPwRe");

        System.out.println("userId = " + userId);
        System.out.println("userPw = " + userPw);
        System.out.println("userPwRe = " + userPwRe);

        if (userPw.equals(userPwRe)) {
            System.out.println("Join success");
            response.sendRedirect("/home");
        }else{
            System.out.println("Join fail");
            response.sendRedirect("/join");
        }
    }
}
