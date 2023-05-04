package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ListProcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 받아온 userId 정보와 일치하는 list 데이터들 select

        // 데이터들과 함께 redirect
        response.sendRedirect("/list");
    }
}
