package com.casestudy1.webapp;

import com.casestudy1.webapp.database.dao.ServicesDAO;
import com.casestudy1.webapp.database.entity.Services;
import com.casestudy1.webapp.services.ServicesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ServicesServiceTest {

    @Autowired
    private ServicesService servicesService;

    @Autowired
    private ServicesDAO servicesDAO;

    @ParameterizedTest
    @CsvSource({
            "Teeth Brushing, Brush the teeth, 20",
            "Basic Bath, Bath with shampoo, 45",
            "Playtime, 30 minute playtime, 25"
    })
    public void addServiceParameterizedTest(String name, String description, int price) {
        // given
        Services service = new Services();
        service.setName(name);
        service.setDescription(description);
        service.setPrice(price);

        // when
        servicesService.addServices(service);

        // then
        Optional<Services> savedService = servicesDAO.findById(service.getServiceid());
        Assertions.assertTrue(savedService.isPresent(), "Saved service should exist in the database");
        Assertions.assertEquals(name, savedService.get().getName(), "Service name should match");
        Assertions.assertEquals(description, savedService.get().getDescription(), "Service description should match");
        Assertions.assertEquals(price, savedService.get().getPrice(), "Service price should match");

        // Cleanup
        savedService.ifPresent(service1 -> servicesDAO.delete(service));
    }

//    @Test
//    public void getAllServicesTest() {
//        // given
//        Services service1 = new Services();
//        service1.setName("Spa");
//        service1.setDescription("Relaxation services for pets");
//        service1.setPrice(100);
//
//        Services service2 = new Services();
//        service2.setName("Pet Sitting");
//        service2.setDescription("Taking care of pets when owners are away");
//        service2.setPrice(60);
//
//        servicesDAO.save(service1);
//        servicesDAO.save(service2);
//
//        // when
//        List<Services> allServices = servicesService.getAllService();
//
//        // then
//        Assertions.assertNotNull(allServices, "All services list should not be null");
//        Assertions.assertTrue(allServices.size() >= 2, "There should be at least 2 services in the database");
//
//        // Cleanup
//        servicesDAO.delete(service1);
//        servicesDAO.delete(service2);
//    }
//
//    @Test
//    public void getServiceByIdTest() {
//        // given
//        Services service = new Services();
//        service.setName("Grooming Deluxe");
//        service.setDescription("Includes bathing and hair trimming");
//        service.setPrice(200);
//
//        servicesDAO.save(service); // Save service to the database
//
//        // when
//        Optional<Services> retrievedService = servicesService.getService(service.getServiceid());
//
//        // then
//        Assertions.assertTrue(retrievedService.isPresent(), "Service should be retrieved by serviceId");
//        Assertions.assertEquals("Grooming Deluxe", retrievedService.get().getName(), "Service name should match");
//        Assertions.assertEquals(200, retrievedService.get().getPrice(), "Service price should match");
//
//        // Cleanup
//        retrievedService.ifPresent(servicesDAO::delete);
//    }
}

