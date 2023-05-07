package handler;

import domain.Member;
import service.MemberService;
import service.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginHandler extends HttpServlet implements CommandHandler{
    MemberService memberService = new MemberServiceImpl();
    @Override
    public String handlerAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        if(userId == null || userPw == null){
            return "/WEB-INF/view/login.jsp";
        }
        Member member = memberService.findMember(userId);
        if (member == null) {
            return "/WEB-INF/view/login.jsp";
        }
        return "/WEB-INF/view/home.jsp";
    }
}
