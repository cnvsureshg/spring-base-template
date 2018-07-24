package com.spring.jdbcgradle.Services.Impl;

import com.spring.jdbcgradle.Entity.Skill;
import com.spring.jdbcgradle.Services.Custom.SkillRepositoryCustom;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class SkillRepositoryImpl implements SkillRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void refresh(Skill skill) {
        em.refresh(skill);
    }
}
