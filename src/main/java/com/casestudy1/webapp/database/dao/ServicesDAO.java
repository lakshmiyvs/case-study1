package com.casestudy1.webapp.database.dao;

import com.casestudy1.webapp.database.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesDAO extends JpaRepository<Services, Integer> {

}
