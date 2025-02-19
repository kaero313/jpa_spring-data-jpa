package jpa;

import jpa.member.dto.Member;
import jpa.member.dto.School;
import jpa.member.service.memberService;
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
import java.util.Map;

@Controller
@RequestMapping("/jpa")
public class jpaController {

    @Autowired
    private memberService memberService;

    @RequestMapping(value = "member/select/all", method = {RequestMethod.POST})
    public List<Member> select_all(HttpServletRequest request){

        List<Member> Members = memberService.findAll(Sort.by(Sort.Direction.ASC, "name"));

        System.out.println(Members);

        return Members;
    }

    @RequestMapping(value = "member/select/where", method = {RequestMethod.POST})
    public List<Member> select_where(@RequestBody String request){

        JSONArray jsonary = new JSONArray(request);

        List<String> ids = new ArrayList<>();

        for(int i=0; i<jsonary.length(); i++){
            JSONObject jo = jsonary.getJSONObject(i);
            System.out.println(jo.getString("id"));
            ids.add(jo.getString("id"));
        }

        List<Member> Members = memberService.findAllById(ids);

        System.out.println(Members);

        return Members;
    }

    @RequestMapping(value = "member/save/one", method = {RequestMethod.POST})
    public void save_one(@RequestBody String request){

        JSONObject jsonobj = new JSONObject(request);

        Member member = new Member();
        member.setId(jsonobj.getString("id"));
        member.setPw(jsonobj.getString("pw"));
        member.setName(jsonobj.getString("name"));

        memberService.save(member);
    }

    @RequestMapping(value = "member/save/all", method = {RequestMethod.POST})
    public void save_all(@RequestBody String request){

        JSONArray jsonary = new JSONArray(request);

        List<Member> lists = new ArrayList<>();

        for(int i=0; i<jsonary.length(); i++){
            JSONObject jo = jsonary.getJSONObject(i);
            Member member = new Member();
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
    public void delete(@RequestBody String request, Member member){

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
    public void select_query_object(HttpServletRequest request, Member member){

        member.setId(request.getParameter("id"));
        member.setPw(request.getParameter("pw"));
        member.setName(request.getParameter("name"));

        System.out.println(memberService.query_object(member));
    }

    @RequestMapping(value = "joincolumn/n_1/save", method = {RequestMethod.POST})
    public void joincolumn_n_1_Save(HttpServletRequest request){

        School school = new School();
        school.setName("TestSchoolName");

        Member member = new Member();
        member.setId("TestMemberId");
        member.setPw("TestMemberPw");
        member.setSchool(school);

        memberService.save(member);

    }

    @RequestMapping(value = "joincolumn/n_1/select", method = {RequestMethod.GET})
    public void joincolumn_n_1_select(HttpServletRequest request){

        School school = new School();
        school.setName("TestSchoolName");

        Member member = new Member();
        member.setSchool(school);



  /*      List<Member> memberList = school.getMembers();
        for(Member member: memberList){
            System.out.println(member.getName());
        }
*/

    }


}
