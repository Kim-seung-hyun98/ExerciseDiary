package service;

import domain.Member;
import repository.MemberRepository;
import repository.MemberRepositoryImpl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class MemberServiceImpl implements MemberService {
    MemberRepository memberRepository = new MemberRepositoryImpl();
    @Override
    public void join(String userId,String userPw,String userPwRe) {
        userPw = validatePassword(userPw, userPwRe);
        Member member = new Member();
        member.setUserId(userId);
        member.setUserPw(userPw);
        validateDuplicateMember(member);
        memberRepository.save(member);
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public String validatePassword(String userPw,String userPwRe) {
        if(!userPw.equals(userPwRe)){
            throw new IllegalStateException("비밀번호가 다릅니다");
        }
        return hash(userPw);
    }
    public void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByUserId(member.getUserId());
        if (findMember != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }
    String hash(String userPw){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        md.update(userPw.getBytes());
        String hex = String.format("%064x", new BigInteger(1, md.digest()));
        return hex;
    }

    @Override
    public Member findMember(String userId) {
        return memberRepository.findByUserId(userId);
    }

    @Override
    public void login(String userId, String userPw) {
        Member member = memberRepository.findByUserId(userId);
        if(member == null){
            throw new IllegalStateException("존재 하지 않은 회원입니다.");
        }
        if(!member.getUserPw().equals(hash(userPw))){
            throw new IllegalStateException("비밀번호가 다릅니다");
        }
    }
}
