package com.casestudy1.webapp.database.dao;

import com.casestudy1.webapp.database.entity.Pets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetsDAO extends JpaRepository<Pets, Integer> {

    public List<Pets> findByUserid(int userid);
}
