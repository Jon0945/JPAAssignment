package se.lexicon.john.JPAAssignment.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.john.JPAAssignment.entity.Product;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TestEntityManager entityManager;

    private Product testProduct;
    private int testId = 0;
    private String testName = "Testbär";
    private int testPrice = 42;

    @BeforeEach
    void createTestProduct(){
        testProduct = entityManager.persistAndFlush(new Product(testId,testName,testPrice));
    }

    @Test
    void given_name_return_List_of_matching_Product_names() {
        List<Product> matchingproducts = productRepository.findByNameContainingIgnoreCase("bÄR");

        assertEquals(1,matchingproducts.size());
        assertEquals("Testbär",matchingproducts.get(0).getName());
    }
}

