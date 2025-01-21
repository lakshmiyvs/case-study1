package com.casestudy1.webapp.services;

import com.casestudy1.webapp.database.entity.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesService {

    @Autowired
    com.casestudy1.webapp.database.dao.ServicesDAO ServicesDAO;

    public Optional<Services> getService(int serviceID) {
        return ServicesDAO.findById(serviceID);
    }

    public void addServices(Services services) {
        ServicesDAO.save(services);
    }

    public List<Services> getAllService() {
        return ServicesDAO.findAll();
    }
}
