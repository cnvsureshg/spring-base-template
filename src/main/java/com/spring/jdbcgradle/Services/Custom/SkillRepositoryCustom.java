package com.spring.jdbcgradle.Services.Custom;

import com.spring.jdbcgradle.Entity.Skill;
import org.springframework.stereotype.Service;

@Service
public interface SkillRepositoryCustom {
    void refresh(Skill skill);
}
