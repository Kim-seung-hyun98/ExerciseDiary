package service;

import domain.Member;
import repository.MemberRepository;
import repository.MemberRepositoryImpl;

import java.util.List;
import java.util.Optional;

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
        memberRepository.findByUserId(member.getUserId()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    @Override
    public Optional<Member> findMember(String userId) {
        return memberRepository.findByUserId(userId);
    }
}
