package se.lexicon.john.JPAAssignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.john.JPAAssignment.entity.AppUser;

import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, String> {
    Optional<AppUser> findByEmailIgnoreCase(String email);
}
