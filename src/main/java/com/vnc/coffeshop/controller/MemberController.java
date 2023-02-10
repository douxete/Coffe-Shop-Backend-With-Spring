package com.vnc.coffeshop.controller;

import com.vnc.coffeshop.entity.Member;
import com.vnc.coffeshop.service.MemberService;
import com.vnc.coffeshop.utils.PageResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping
    public Member insertMember(@RequestBody Member member){
        return memberService.addMember(member);
    }

//    @GetMapping
//    public List<Member> getAllMember(){
//        return memberService.getAllMember();
//    }

    @GetMapping
    public PageResponseWrapper<Member> getMemberPerPage(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(name = "size", defaultValue = "5") Integer size,
                                                        @RequestParam(name = "sortBy", defaultValue = "username") String sortBy,
                                                        @RequestParam(name = "direction", defaultValue = "ASC") String direction){
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Member> memberPage = memberService.getMemberPerPage(pageable);
        return new PageResponseWrapper<>(memberPage);
    }

    @GetMapping("/search")
    public List<Member> searchMember(@RequestParam String username){
        return memberService.searchMemberName(username);
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable String id){
        return memberService.getMemberById(id);
    }

    @PutMapping
    public Member updateMember(@RequestBody Member member){
        return memberService.updateMember(member);
    }

    @DeleteMapping
    public void deleteMember(@RequestParam String id){
        memberService.deleteMember(id);
    }
}
