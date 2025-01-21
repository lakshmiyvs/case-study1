package com.casestudy1.webapp.services;

import com.casestudy1.webapp.database.dao.UsersDAO;
import com.casestudy1.webapp.database.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    UsersDAO usersDAO;

    public Users geUsersByEmail(String email) {

        return usersDAO.findByEmail(email);
    }

    public void addUser(Users users) {
        usersDAO.save(users);

    }
}
