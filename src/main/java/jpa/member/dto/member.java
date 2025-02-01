package jpa.member.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name= "member")
public class member {

    @Id
    @Column(name= "id", nullable = false)
    private String id;

    @Column(name= "pw", nullable = false)
    private String pw;

    @Column(name= "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="name")
    private school school;

}
