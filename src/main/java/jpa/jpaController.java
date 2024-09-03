package jpa;

import jpa.member.dto.member;
import jpa.member.service.memberService;
import org.assertj.core.util.Lists;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
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

    @RequestMapping(value = "member/count", method = {RequestMethod.POST})
    public void count(@RequestBody String request){

        System.out.println(memberService.count());

    }

    @RequestMapping(value = "member/delete", method = {RequestMethod.POST})
    public void delete(@RequestBody String request, member member){

        JSONObject jsonobj = new JSONObject(request);

        member.setId(jsonobj.getString("id"));
        member.setPw(jsonobj.getString("pw"));
        member.setName(jsonobj.getString("name"));

        memberService.delete(member);
    }

    @RequestMapping(value = "member/delete/id", method = {RequestMethod.GET})
    public void delete_id(HttpServletRequest request){

        memberService.deleteById(request.getParameter("id"));
    }

    @RequestMapping(value = "member/select/query", method = {RequestMethod.GET})
    public void select_query(HttpServletRequest request){

        System.out.println(memberService.query(request.getParameter("id"),
                request.getParameter("pw"), request.getParameter("name")));
    }

    @RequestMapping(value = "member/select/query_param", method = {RequestMethod.GET})
    public void select_query_param(HttpServletRequest request){

        System.out.println(memberService.query_param(request.getParameter("id"),
                request.getParameter("pw"), request.getParameter("name")));
    }

    @RequestMapping(value = "member/select/query_object", method = {RequestMethod.GET})
    public void select_query_object(HttpServletRequest request, member member){

        member.setId(request.getParameter("id"));
        member.setPw(request.getParameter("pw"));
        member.setName(request.getParameter("name"));

        System.out.println(memberService.query_object(member));
    }


}
