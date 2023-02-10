package com.vnc.coffeshop.service;

import com.vnc.coffeshop.entity.Coffee;
import com.vnc.coffeshop.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberService {
    public Member addMember(Member member);
    public Member getMemberById(String id);
    public List<Member> getAllMember();
    public Member updateMember(Member member);
    public void  deleteMember(String id);
    public Page<Member> getMemberPerPage(Pageable pageable);
    List<Member> searchMemberName(String name);
}
