package jpa.member.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name= "Member")
public class Member {

    @Id
    @Column(name= "id", nullable = false)
    private String id;

    @Column(name= "pw", nullable = false)
    private String pw;

    @Column(name= "name")
    private String name;

    // 연관관계의 주인은 외래키가 있는쪽이 주인이 됨(mappedBy를 사용하지 않음)
    @ManyToOne
    @JoinColumn(name="school_name")
    private School school;

}
