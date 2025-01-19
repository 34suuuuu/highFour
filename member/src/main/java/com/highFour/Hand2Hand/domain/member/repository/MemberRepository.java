package com.highFour.Hand2Hand.domain.member.repository;

import com.highFour.Hand2Hand.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
