package com.jpa.demo.repository;

import com.jpa.demo.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findByName(String name);

//    Team findByTeamId(ling id )
//
//    @Query("select t from Team t where t.teamId = ?1")
//    List<Team> findByTeamId(long teamId);



}
