package com.casestudy1.webapp.services;


import com.casestudy1.webapp.database.dao.UserRoleDAO;
import com.casestudy1.webapp.database.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    UserRoleDAO userRoleDAO;

    public List<UserRole> findAllUser() {
        return userRoleDAO.findAll();
    }



}
