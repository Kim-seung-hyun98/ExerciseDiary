package service;

import domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    void join(Member member);
    List<Member> findMembers();
    Optional<Member> findMember(String userId);
    void validateDuplicateMember(Member member);
}
