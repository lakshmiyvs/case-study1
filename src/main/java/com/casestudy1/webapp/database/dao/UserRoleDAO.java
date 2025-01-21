package com.casestudy1.webapp.database.dao;

import com.casestudy1.webapp.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDAO extends JpaRepository<UserRole, Integer> {
}
