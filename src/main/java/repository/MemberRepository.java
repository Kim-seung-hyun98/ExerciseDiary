package repository;

import domain.Member;

import java.util.List;

public interface MemberRepository {
    Member save(Member member);
    Member findByUserId(String UserId);
    List<Member> findAll();
    void clearStore();
}
