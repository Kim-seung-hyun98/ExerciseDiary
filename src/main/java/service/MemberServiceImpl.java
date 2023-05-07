package service;

import domain.Member;
import repository.MemberRepository;
import repository.MemberRepositoryImpl;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    MemberRepository memberRepository = new MemberRepositoryImpl();
    @Override
    public void join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByUserId(member.getUserId());
        if (findMember != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    @Override
    public Member findMember(String userId) {
        return memberRepository.findByUserId(userId);
    }
}
