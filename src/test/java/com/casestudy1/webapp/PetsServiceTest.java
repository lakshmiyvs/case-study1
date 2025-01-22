package com.casestudy1.webapp;

import com.casestudy1.webapp.database.dao.PetsDAO;
import com.casestudy1.webapp.database.entity.Pets;
import com.casestudy1.webapp.services.PetsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PetsServiceTest {

    @Autowired
    private PetsService petsService;

    @Autowired
    private PetsDAO petsDAO;

    @Test
    public void getPetByUserIdTest() {
        // given
        int userId = 6;

        Pets pet = new Pets();
        pet.setName("Buddy");
        pet.setType("small");
        pet.setAge(3);
        pet.setBreed("Labrador");
        pet.setUserid(userId); // Assuming you have a userId setter
        petsDAO.save(pet); // Save the pet to the database

        // when
        List<Pets> actualPets = petsService.getPetByUserId(userId);

        // then
        Assertions.assertNotNull(actualPets, "Pets list should not be null");
        Assertions.assertFalse(actualPets.isEmpty(), "Pets list should not be empty");
        Assertions.assertEquals(1, actualPets.size(), "There should be one pet associated with the user");
        Assertions.assertEquals("Buddy", actualPets.get(0).getName(), "Pet name should match");

        // Cleanup
        petsDAO.delete(pet);
    }

    @Test
    public void addPetTest() {
        // given
        int userId = 5;
        Pets newPet = new Pets();
        newPet.setName("Charlie");
        newPet.setType("Medium");
        newPet.setAge(2);
        newPet.setBreed("Siamese");
        newPet.setUserid(userId);

        // when
        petsService.addPet(newPet);

        // then
        Optional<Pets> savedPet = petsDAO.findById(newPet.getPetid());
        Assertions.assertTrue(savedPet.isPresent(), "Saved pet should exist in the database");
        Assertions.assertEquals("Charlie", savedPet.get().getName(), "Pet name should match");
        Assertions.assertEquals("Medium", savedPet.get().getType(), "Pet type should match");
        Assertions.assertEquals(2, savedPet.get().getAge(), "Pet age should match");

        // Cleanup
        savedPet.ifPresent(petsDAO::delete);
    }

    @Test
    public void getByPetIdTest() {
        // given
        int userId = 5;
        Pets pet = new Pets();
        pet.setName("Max");
        pet.setType("Large");
        pet.setAge(1);
        pet.setBreed("GermanShepard");
        pet.setUserid(userId);
        petsDAO.save(pet); // Save pet to the database

        // when
        Optional<Pets> actualPet = petsService.getByPetId(pet.getPetid());

        // then
        Assertions.assertTrue(actualPet.isPresent(), "Pet should be retrieved by petId");
        Assertions.assertEquals("Max", actualPet.get().getName(), "Pet name should match");
        Assertions.assertEquals("Large", actualPet.get().getType(), "Pet type should match");

        // Cleanup
        actualPet.ifPresent(petsDAO::delete);
    }
}
