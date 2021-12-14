package com.jpa.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL_AutoIncrement
    long memberId;

    String memberName;

    int salary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teamId")
    Team teamId;
}
