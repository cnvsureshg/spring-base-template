package com.spring.jdbcgradle.Repository;

import com.spring.jdbcgradle.Entity.User;
import com.spring.jdbcgradle.Services.Custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {
    List<User> findByFirstname(String firstname);
}
