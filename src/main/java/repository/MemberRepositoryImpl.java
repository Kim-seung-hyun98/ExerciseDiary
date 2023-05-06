package repository;

import domain.Member;

import java.util.*;

public class MemberRepositoryImpl implements MemberRepository {
    private static Map<String,Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getUserId(),member);
        return member;
    }

    @Override
    public Optional<Member> findByUserId(String userId) {
        return Optional.ofNullable(store.get(userId));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    @Override
    public void clearStore(){store.clear();}
}
