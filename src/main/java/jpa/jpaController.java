package jpa;

import jpa.member.dto.member;
import jpa.member.service.memberService;
import org.assertj.core.util.Lists;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

        List<member> members = memberService.findAll(Sort.by(Sort.Direction.ASC, "name"));

        System.out.println(members);

        return members;
    }

    @RequestMapping(value = "member/select/where", method = {RequestMethod.POST})
    public List<member> select_where(@RequestBody String request){

        JSONArray jsonary = new JSONArray(request);

        List<String> ids = new ArrayList<>();

        for(int i=0; i<jsonary.length(); i++){
            JSONObject jo = jsonary.getJSONObject(i);
            System.out.println(jo.getString("id"));
            ids.add(jo.getString("id"));
        }

        List<member> members = memberService.findAllById(ids);

        System.out.println(members);

        return members;
    }

    @RequestMapping(value = "member/save/one", method = {RequestMethod.POST})
    public void save_one(@RequestBody String request){

        JSONObject jsonobj = new JSONObject(request);

        member member = new member();
        member.setId(jsonobj.getString("id"));
        member.setPw(jsonobj.getString("pw"));
        member.setName(jsonobj.getString("name"));

        memberService.save(member);
    }

    @RequestMapping(value = "member/save/all", method = {RequestMethod.POST})
    public void save_all(@RequestBody String request){

        JSONArray jsonary = new JSONArray(request);

        List<member> lists = new ArrayList<>();

        for(int i=0; i<jsonary.length(); i++){
            JSONObject jo = jsonary.getJSONObject(i);
            member member = new member();
            member.setId(jo.getString("id"));
            member.setPw(jo.getString("pw"));
            member.setName(jo.getString("name"));
            lists.add(member);
        }

        memberService.saveAll(lists);
    }



}
