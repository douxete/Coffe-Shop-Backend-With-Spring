package com.vnc.coffeshop.service;

import com.vnc.coffeshop.entity.Coffee;
import com.vnc.coffeshop.entity.Member;
import com.vnc.coffeshop.exception.DataNotFoundException;
import com.vnc.coffeshop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member getMemberById(String id) {
        verify(id);
        return memberRepository.findById(id).get();
    }

    @Override
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    @Override
    public Member updateMember(Member member) {
        verify(member.getId());
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(String id) {
        verify(id);
        memberRepository.deleteById(id);
    }

    @Override
    public Page<Member> getMemberPerPage(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    @Override
    public List<Member> searchMemberName(String name) {
        return memberRepository.findMemberByUsernameContaining(name);
    }

    public void verify(String id) {
        if (!memberRepository.findById(id).isPresent()) {
            String message = "Member not found";
            throw new DataNotFoundException(message);
        }
    }
}
