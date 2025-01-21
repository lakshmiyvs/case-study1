package com.casestudy1.webapp.services;


import com.casestudy1.webapp.database.dao.AppointmentDAO;
import com.casestudy1.webapp.database.entity.Appointments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    AppointmentDAO appointmentsDAO;

    public void addAppointment(Appointments appointments) {
        appointmentsDAO.save(appointments);

    }

    public List<Appointments> getAllAppointment() {
        return appointmentsDAO.findAll();

    }

    public List<Appointments> getAllAppointmentByUserid(int userID) {
        return appointmentsDAO.findByUserid(userID);

    }

    public Optional<Appointments> getAppointmentById(int id) {
        return appointmentsDAO.findById(id);

    }
}

