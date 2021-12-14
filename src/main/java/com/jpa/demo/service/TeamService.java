package com.jpa.demo.service;

import com.jpa.demo.domain.Team;
import com.jpa.demo.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class TeamService {

    private final TeamRepository teamRepository;

    public void insertTeam(Team team){
        teamRepository.saveAndFlush(team);

    };

    public void updateTeam(Team team){
        teamRepository.saveAndFlush(team);
    };

    public Team selectTeamByName(String name){
        return teamRepository.findByName(name);
    };

    public void deleteTeam(Team team){
        teamRepository.delete(team);
        teamRepository.flush();
    };
}
