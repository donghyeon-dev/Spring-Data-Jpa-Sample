package com.jpa.demo.service;

import com.jpa.demo.domain.Member;
import com.jpa.demo.domain.Member;
import com.jpa.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public void insertMember(Member member){
        memberRepository.saveAndFlush(member);

    };

    public void updateMember(Member member){
        memberRepository.saveAndFlush(member);
    };

    public Member selectMemberByName(String name){
        return memberRepository.findByMemberName(name);
    };

    public void deleteMember(Member member){
        memberRepository.delete(member);
        memberRepository.flush();
    };
}
