package se.lexicon.john.JPAAssignment.data;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.lexicon.john.JPAAssignment.entity.AppUser;
import se.lexicon.john.JPAAssignment.entity.OrderItem;
import se.lexicon.john.JPAAssignment.entity.Product;
import se.lexicon.john.JPAAssignment.entity.ProductOrder;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductOrderRepositoryTest {

    @Autowired
    ProductOrderRepository productOrderRepository;

    @Autowired
    TestEntityManager entityManager;

    private ProductOrder testProductOrder;
    private Product testProduct = new Product("Testbär", 42);
    private OrderItem testOrderItem;
    private LocalDateTime testLocalDateTime = LocalDateTime.of(2019, 11, 12, 12, 0);
    private Set<OrderItem> testProducts;
    private AppUser testCustomer = new AppUser("Ture", "Test", "ture.test@gmail.com");

    @BeforeEach
    void createTestProductOrder() {
        testCustomer = entityManager.persistAndFlush(new AppUser("Ture", "Test", "ture.test@gmail.com"));
        testProductOrder = entityManager.persistAndFlush(new ProductOrder(testLocalDateTime,testCustomer));
        testOrderItem = entityManager.persistAndFlush(new OrderItem(12, testProduct));
    }


}
