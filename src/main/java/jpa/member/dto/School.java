package jpa.member.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name= "School")
public class School {

    @Id
    @Column(name= "name", nullable = false)
    private String name;

    @Column(name= "address")
    private String address;

    @Column(name= "grade")
    private String grade;

    //양방향 매핑을 위해 추가
    @OneToMany(mappedBy = "school")
    private List<Member> members = new ArrayList<>();

}
