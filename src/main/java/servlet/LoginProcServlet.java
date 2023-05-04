package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginProcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // DB에 data저장

        // if login 성공 userId 같이 보냄
        response.sendRedirect("/list-proc");
        // else login 실패
        response.sendRedirect("/login");
    }
}
