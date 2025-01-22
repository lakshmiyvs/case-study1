package com.casestudy1.webapp;

import com.casestudy1.webapp.database.dao.UsersDAO;
import com.casestudy1.webapp.database.entity.Users;
import com.casestudy1.webapp.services.UsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UsersServiceTest {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersDAO usersDAO;

    @Test
    public void getUserByEmailTest() {
        // given
        String email = "larry@gmail.com";

        Users user = new Users();
//        user.setUserid(1); // If `userid` is auto-generated, skip setting it here
        user.setName("Larry");
        user.setEmail(email);
        user.setPassword("larry123");
        user.setPhone("1234567890");
        user.setUserRoleid(0);
        usersDAO.save(user); // Save setup data to the database

        // when
        Users actual = usersService.geUsersByEmail(email);

        // then
        Assertions.assertEquals("larry@gmail.com", actual.getEmail());
        Assertions.assertEquals("Larry", actual.getName());
//        Assertions.assertNotEquals("larry123", actual.getPassword());

        // Cleanup
        usersDAO.delete(user);
    }



    @Test
    public void createUserTest() {
        // given
        Users newUser = new Users();
//        newUser.setUserid(); // If auto-generated, remove
        newUser.setName("Skib");
        newUser.setEmail("skib@gmail.com");
        newUser.setPassword("password123");
        newUser.setPhone("0987654321");
        newUser.setUserRoleid(0);

        // when
        usersService.addUser(newUser);

        // then
        Users savedUser = usersService.geUsersByEmail(newUser.getEmail());
        Assertions.assertNotNull(savedUser, "Saved user should exist in the database");
        Assertions.assertEquals("Skib", savedUser.getName(), "Name should match");
        Assertions.assertEquals("password123", savedUser.getPassword(), "Password should match");
        Assertions.assertEquals("skib@gmail.com", savedUser.getEmail(), "Email should match");

        // Cleanup
        usersDAO.delete(savedUser);
    }
}