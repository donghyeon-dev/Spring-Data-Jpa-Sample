package com.jpa.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import com.jpa.demo.domain.Team;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TeamServiceTest {

    @Autowired
    TeamService teamService;


    @Test
    public void 인서트_테스트(){
        String name = "박동현";
        Team team = Team.builder()
                .name(name)
                .build();
        teamService.insertTeam(team);

        Team targetTeam = teamService.selectTeamByName(name);

        assertEquals(team.getName(), targetTeam.getName());
    }

    @Test
    public void 업데이트_테스트(){
        String name = "박동현";
        String anotherName = "긷동현";
        Team team = Team.builder()
                .name(name)
                .build();
        teamService.insertTeam(team);

        Team insertedTeam = teamService.selectTeamByName(name);

        Team updateTeam = Team.builder()
                        .name(anotherName)
                        .teamId(insertedTeam.getTeamId())
                        .build();

        teamService.updateTeam(updateTeam);

        // Insert한 엔티티와 Update한 엔티티의 name 값은 같지 않다.
        assertNotEquals(teamService.selectTeamByName(anotherName).getName(),
                insertedTeam.getName());
    }

    @Test
    public void 딜리트_테스트(){
        String name = "박동현";
        Team team = Team.builder()
                .name(name)
                .build();
        teamService.insertTeam(team);

        Team insertedTeam = teamService.selectTeamByName(name);

        teamService.deleteTeam(insertedTeam);

        assertNull(teamService.selectTeamByName(name));
    }

}