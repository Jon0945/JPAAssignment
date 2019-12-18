package se.lexicon.john.JPAAssignment.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.lexicon.john.JPAAssignment.entity.AppUser;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AppUserRepositoryTest {
    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    TestEntityManager entityManager;

    private AppUser testUser;
    private String testFirstName = "Ture";
    private String testLastName = "Test";
    private String testEmail = "ture.test@gmail.com";

    @BeforeEach
    void createTestUser(){
        testUser = entityManager.persistAndFlush(new AppUser(testFirstName,testLastName,testEmail));
    }

    @Test
    void given_valid_email_findByEmail_return_AppUser() {
        Optional<AppUser> matchingUser = appUserRepository.findByEmailIgnoreCase("ture.test@gmail.com");

        assertTrue(matchingUser.isPresent());
    }
}
