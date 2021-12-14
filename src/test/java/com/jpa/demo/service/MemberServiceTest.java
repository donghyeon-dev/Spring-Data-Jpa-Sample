package com.jpa.demo.service;

import com.jpa.demo.domain.Member;
import com.jpa.demo.domain.Team;
import com.jpa.demo.repository.MemberRepository;
import com.jpa.demo.repository.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class MemberServiceTest {

    @Autowired
    private TeamService teamService;

    @Autowired
    private MemberService memberService;

    @BeforeEach
    void insertTeam_be(){
        String name = "박동현";
        Team team = Team.builder()
                .name(name)
                .build();
        teamService.insertTeam(team);
    }

    @Test
    void insertMember_테스트() {

        Team insertedTeam = teamService.selectTeamByName("박동현");
        Member newMember = Member.builder()
                .memberName("1번멤버")
                .salary(3000)
                .teamId(insertedTeam)
                .build();

        memberService.insertMember(newMember);

        Member targetMember = memberService.selectMemberByName("1번멤버");

        assertEquals(targetMember.getTeamId().getTeamId(), insertedTeam.getTeamId());
    }

    @Test
    void updateMember_테스트() {

        Team insertedTeam = teamService.selectTeamByName("박동현");

        Member newMember = Member.builder()
                .memberName("1번멤버")
                .salary(3000)
                .teamId(insertedTeam)
                .build();

        memberService.insertMember(newMember);

        Member targetMember = memberService.selectMemberByName("1번멤버");

        Member updateMember = Member.builder()
                .memberName("99번멤버")
                .salary(4000)
                .teamId(insertedTeam)
                .memberId(targetMember.getMemberId())
                .build();


        memberService.updateMember(updateMember);

        assertNotEquals(newMember.getSalary(), updateMember.getSalary());
        assertNotEquals(newMember.getMemberName(), updateMember.getMemberName());


    }

    @Test
    void deleteMember_테스트() {

        Team targetTeam = teamService.selectTeamByName("박동현");

        Member newMember = Member.builder()
                .memberName("1번멤버")
                .salary(3000)
                .teamId(targetTeam)
                .build();

        memberService.insertMember(newMember);

        Member deleteMember = memberService.selectMemberByName("1번멤버");

        memberService.deleteMember(deleteMember);

        assertNull(memberService.selectMemberByName("1번멤버"));

    }
}