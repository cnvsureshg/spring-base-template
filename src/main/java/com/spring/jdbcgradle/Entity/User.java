package com.spring.jdbcgradle.Entity;

import com.spring.jdbcgradle.Commons.Roles;
import com.spring.jdbcgradle.Entity.Model.AuditModel;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
//@EqualsAndHashCode(callSuper = false)
//@NoArgsConstructor
public class User extends AuditModel {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column
    @NotNull
    @Size(min = 5, max = 50)
    private String firstname;

    @Enumerated(EnumType.STRING)
    //set default enum value as like below
    @Column(length = 15, columnDefinition = "varchar(15) default 'USER'")
    private Roles role = Roles.USER;


    @Override
    public String toString() {
        return String.format("User [id=%d, firstname=%s, role=%s]", id, firstname, role);
    }
}
