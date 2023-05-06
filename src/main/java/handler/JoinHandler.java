package handler;

import domain.Member;
import service.MemberService;
import service.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JoinHandler extends HttpServlet implements CommandHandler{
    MemberService memberService = new MemberServiceImpl();
    @Override
    public String handlerAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/WEB-INF/view/join.jsp";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String userPw = req.getParameter("userPw");
        String userPwRe = req.getParameter("userPwRe");
        System.out.println("userPw = " + userPw);
        System.out.println("userPwRe = " + userPwRe);
        if(userPw.equals(userPwRe)){
            Member member = new Member();
            member.setUserId(userId);
            memberService.join(member);
            System.out.println("회원가입 성공");
            resp.sendRedirect("/home");
        }
        resp.sendRedirect("/join");
    }
}
