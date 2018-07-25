package com.spring.jdbcgradle.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.jdbcgradle.Commons.Roles;
import com.spring.jdbcgradle.Entity.Model.AuditModel;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(targetEntity = Skill.class)
    @JoinColumn(name = "skill_id", nullable = false)
    @JoinTable(name = "user_skill",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_id")})
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference
    private Set<Skill> skills = new HashSet<Skill>();

    @Override
    public String toString() {
        String info = "";
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("firstname", this.firstname);
        JSONArray subArray = new JSONArray();
        this.skills.forEach(skill -> {
            JSONObject subJson = new JSONObject();
            subJson.put("name", skill.getName());
            subJson.put("id", skill.getId());
            subArray.add(subJson);
        });
        jsonInfo.put("skills", subArray);
        info = jsonInfo.toString();
        return info;
    }

}


// Could not write JSON: Infinite recursion (StackOverflowError);nested exception is com.fasterxml.jackson.databind.JsonMappingException: Infinite recursion (StackOverflowError) (through reference chain: org.json.simple.JSONObject[\"content\"]->com.spring.jdbcgradle.Entity.User[\"skill\"])