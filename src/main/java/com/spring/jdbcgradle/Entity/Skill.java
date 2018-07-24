package com.spring.jdbcgradle.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.jdbcgradle.Entity.Model.AuditModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

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
    @Size(min=3, max=50)
    private String skill;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private User user;

    @Override
    public String toString() {
        return String.format("Skill [id=%d, skill=%s]", id, skill);
    }
}
