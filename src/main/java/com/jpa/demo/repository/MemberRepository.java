package com.jpa.demo.repository;

import com.jpa.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByMemberName(String memberName);

}
