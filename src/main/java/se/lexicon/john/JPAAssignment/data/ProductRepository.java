package se.lexicon.john.JPAAssignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.john.JPAAssignment.entity.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByNameContainingIgnoreCase(String productname);
}
