package jpa.member.service;

import jpa.member.dto.Member;
import jpa.member.repository.memberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class memberService {

    @Autowired
    private memberRepository memberRepository;

    public List<Member> findAll(Sort sort) {
        List<Member> Members = new ArrayList<>();
        memberRepository.findAll(sort).forEach(e -> Members.add(e));
        return Members;
    }

    public List<Member> findAllById(List<String> lists) {
        List<Member> Members = memberRepository.findAllById(lists);
        return Members;
    }

    public void save(Member member) {
        memberRepository.save(member);
    }

    public void saveAll(List<Member> lists) {
        memberRepository.saveAll(lists);
    }

    public long count() {
        return memberRepository.count();
    }

    public void delete(Member member) {
        memberRepository.delete(member);
    }

    public void deleteById(String id) {
        memberRepository.deleteById(id);
    }

    public List<Member> query(String id, String pw, String name) {
        return memberRepository.query(id, pw, name);
    }

    public List<Member> query_param(String id, String pw, String name) {
        return memberRepository.query_param(id, pw, name);
    }

    public List<Member> query_object(Member member) {
        return memberRepository.query_object(member);
    }
}
