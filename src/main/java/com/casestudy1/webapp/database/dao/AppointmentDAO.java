package com.casestudy1.webapp.database.dao;

import com.casestudy1.webapp.database.entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public 	interface AppointmentDAO extends JpaRepository<Appointments, Integer> {

//    public List<Appointments> findByUserId(int userID);

    @Query("SELECT a FROM Appointments a WHERE a.userid = :userid")
    public List<Appointments> findByUserid(@Param("userid") int userid);

}
