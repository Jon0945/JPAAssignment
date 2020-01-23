package se.lexicon.john.JPAAssignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.john.JPAAssignment.entity.ProductOrder;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductOrderRepository extends CrudRepository<ProductOrder, Integer> {

    List<ProductOrder> findByCustomerAppuserid (int appuserid);
    List<ProductOrder> findByProductsProductProductname (String productname);
    List<ProductOrder> findByProductsProductProductid (int productid);
    List<ProductOrder> findByOrderDateTimeBetween (LocalDateTime start, LocalDateTime end);
}
