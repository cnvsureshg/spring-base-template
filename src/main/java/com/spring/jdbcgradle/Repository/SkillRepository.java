package com.spring.jdbcgradle.Repository;

import com.spring.jdbcgradle.Entity.Skill;
import com.spring.jdbcgradle.Services.Custom.SkillRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer>, SkillRepositoryCustom {
}
