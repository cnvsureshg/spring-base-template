package com.spring.jdbcgradle.Services.Impl;

import com.spring.jdbcgradle.Entity.User;
import com.spring.jdbcgradle.Services.Custom.UserRepositoryCustom;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class UserRepositoryImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public void refresh(User user) {
        em.refresh(user);
    }
}
