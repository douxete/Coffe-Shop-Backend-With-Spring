package com.vnc.coffeshop.repository;

import com.vnc.coffeshop.entity.Coffee;
import com.vnc.coffeshop.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {
    List<Member> findMemberByUsernameContaining(String name);
}
