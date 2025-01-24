package jpa.member.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name= "school")
public class school {

    @Id
    @Column(name= "name", nullable = false)
    private String name;

    @Column(name= "address")
    private String address;

    @Column(name= "grade")
    private String grade;

}
