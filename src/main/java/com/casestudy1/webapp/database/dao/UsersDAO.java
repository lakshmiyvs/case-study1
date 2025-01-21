package com.casestudy1.webapp.database.dao;

import com.casestudy1.webapp.database.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDAO extends JpaRepository<Users, Integer> {

    public Users findByEmail(String email);

}
