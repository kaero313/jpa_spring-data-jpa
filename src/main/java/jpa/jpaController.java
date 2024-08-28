package jpa;

import jpa.member.dto.member;
import jpa.member.service.memberService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/jpa")
public class jpaController {

    @Autowired
    private memberService memberService;

    @RequestMapping(value = "member/select/all", method = {RequestMethod.POST})
    public List<member> select_all(HttpServletRequest request){

        List<member> members = memberService.findAll();

        System.out.println(members);

        return members;
    }

    @RequestMapping(value = "member/select/where", method = {RequestMethod.POST})
    public List<member> select_where(HttpServletRequest request){

        List<String> lists = new ArrayList<>();
        lists.add("id1");
        lists.add("id55");

        List<member> members = memberService.findAllById(lists);

        System.out.println(members);

        return members;
    }

}
