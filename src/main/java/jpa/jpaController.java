package jpa;

import jpa.member.dto.member;
import jpa.member.service.memberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/jpa")
public class jpaController {

    @Autowired
    private memberService memberService;

    @RequestMapping(value = "member/select", method = {RequestMethod.POST})
    public List<member> select(){
        List<member> members = memberService.findAll();

        System.out.println(members);

        return members;
    }

}
