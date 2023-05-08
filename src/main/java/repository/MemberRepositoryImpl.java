package repository;

import domain.Member;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class MemberRepositoryImpl implements MemberRepository {
    private static Map<String,Member> store = new HashMap<>();
    @Override
    public Member save(Member member) {
        System.out.println(member.getUserPw());
        store.put(member.getUserId(),member);
        return member;
    }

    @Override
    public Member findByUserId(String userId) {
        return store.get(userId);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    @Override
    public void clearStore(){store.clear();}
}
