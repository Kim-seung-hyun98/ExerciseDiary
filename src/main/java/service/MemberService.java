package service;

import domain.Member;

import java.util.List;

public interface MemberService {
    void join(String userId,String userPw,String userPwRe);
    List<Member> findMembers();
    Member findMember(String userId);

    void login(String userId, String userPw);
}
