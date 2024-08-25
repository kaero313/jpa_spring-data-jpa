package jpa.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="member")
public class member {

    @Id
    @Column(name= "id", nullable = false)
    private String id;

    @Column(name= "pw", nullable = false)
    private String pw;

    @Column(name= "name")
    private String name;

}
