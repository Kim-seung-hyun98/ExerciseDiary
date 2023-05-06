package repository;

import domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByUserId(String UserId);
    List<Member> findAll();
    void clearStore();
}
