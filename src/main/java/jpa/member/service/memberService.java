package jpa.member.service;

import jpa.member.dto.member;
import jpa.member.repository.memberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class memberService {

    @Autowired
    private memberRepository memberRepository;

    public List<member> findAll() {
        List<member> members = new ArrayList<>();
        memberRepository.findAll().forEach(e -> members.add(e));
        return members;
    }

}
