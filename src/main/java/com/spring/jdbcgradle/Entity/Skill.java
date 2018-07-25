package com.spring.jdbcgradle.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.jdbcgradle.Entity.Model.AuditModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
//@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Skill extends AuditModel {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column
    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @Column
    @Size(max=10)
    private String status = "Active";

    @OneToMany(mappedBy = "skills")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
//    @JsonSerialize(using = UserSerializer.class)
    private Set<User> users;

    @Override
    public String toString() {
        return String.format("Skill [id=%d, skill=%s]", id, name);
    }
}
