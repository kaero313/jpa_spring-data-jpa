package jpa.member.service;

import jpa.member.dto.member;
import jpa.member.repository.memberRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class memberService {

    @Autowired
    private memberRepository memberRepository;

    public List<member> findAll(Sort sort) {
        List<member> members = new ArrayList<>();
        memberRepository.findAll(sort).forEach(e -> members.add(e));
        return members;
    }

    public List<member> findAllById(List<String> lists) {
        List<member> members = memberRepository.findAllById(lists);
        return members;
    }


    public member save(member member) {
        memberRepository.save(member);
        return member;
    }
}
