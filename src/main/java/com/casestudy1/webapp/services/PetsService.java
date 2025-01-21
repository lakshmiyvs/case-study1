package com.casestudy1.webapp.services;

import com.casestudy1.webapp.database.dao.PetsDAO;
import com.casestudy1.webapp.database.entity.Pets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetsService {

    @Autowired
    PetsDAO petsDAO;

    public void addPet(Pets pets) {
        petsDAO.save(pets);

    }

    public List<Pets> getPetByUserId(int userid) {
        return petsDAO.findByUserId(userid);

    }

    public Optional<Pets> getByPetId(int petId) {
        return petsDAO.findById(petId);

    }

}
