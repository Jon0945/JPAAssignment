package se.lexicon.john.JPAAssignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.john.JPAAssignment.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer > {
}
