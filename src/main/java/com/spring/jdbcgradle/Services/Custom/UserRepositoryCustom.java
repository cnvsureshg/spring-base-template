package com.spring.jdbcgradle.Services.Custom;

import com.spring.jdbcgradle.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserRepositoryCustom {
    void refresh(User user);
}
