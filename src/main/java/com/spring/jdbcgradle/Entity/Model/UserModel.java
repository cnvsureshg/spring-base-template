package com.spring.jdbcgradle.Entity.Model;

import com.spring.jdbcgradle.Commons.Roles;
import lombok.Data;
import org.json.simple.JSONObject;
import java.util.List;


@Data
public class UserModel {
    private Integer id;
    private String firstname;
    private Roles role;
    private List<JSONObject> skills;
}
