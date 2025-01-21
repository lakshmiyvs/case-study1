package com.casestudy1.webapp;

import com.casestudy1.webapp.database.dao.UsersDAO;
import com.casestudy1.webapp.database.entity.Users;
import com.casestudy1.webapp.services.UsersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class UserServiceTest {

    @Mock
    private UsersDAO usersDAO; // Mocked dependency

    @InjectMocks
    private UsersService usersService; // Service under test

    @Test
    public void testGeUsersByEmail() {
        // Arrange
        String email = "test@example.com";
        Users mockUser = new Users(); // Assuming a default constructor for Users class
        mockUser.setEmail(email);
        when(usersDAO.findByEmail(email)).thenReturn(mockUser);

        // Act
        Users result = usersService.geUsersByEmail(email);

        // Assert
        assertNotNull(result);
        assertEquals(email, result.getEmail());
        verify(usersDAO, times(1)).findByEmail(email); // Verify interaction with DAO
    }

//    @Test
//    public void testAddUser() {
//        // Arrange
//        Users newUser = new Users(); // Assuming a default constructor for Users class
//        newUser.setEmail("test@example.com");
//
//        doNothing().when(usersDAO).save(newUser); // Mock save operation
//
//        // Act
//        usersService.addUser(newUser);
//
//        // Assert
//        verify(usersDAO, times(1)).save(newUser); // Verify save method was called
//    }

    @Test
    public void testGeUsersByEmail_NotFound() {
        // Arrange
        String email = "nonexistent@example.com";
        when(usersDAO.findByEmail(email)).thenReturn(null);

        // Act
        Users result = usersService.geUsersByEmail(email);

        // Assert
        assertNull(result);
        verify(usersDAO, times(1)).findByEmail(email); // Verify interaction with DAO
    }
}
