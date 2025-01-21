package com.casestudy1.webapp.database.dao;

import com.casestudy1.webapp.database.entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public 	interface AppointmentDAO extends JpaRepository<Appointments, Integer> {

    public List<Appointments> findByUserId(int userID);

}
