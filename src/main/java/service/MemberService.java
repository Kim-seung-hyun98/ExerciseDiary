package service;

import domain.Member;

import java.util.List;

public interface MemberService {
    void join(Member member);
    List<Member> findMembers();
    Member findMember(String userId);
    void validateDuplicateMember(Member member);
}
