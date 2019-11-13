package se.lexicon.john.JPAAssignment.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

public class OrderItem {

    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderitem_id;
    private int quantity;
    @Column(unique = true)
    private Product product;
    private ProductOrder productOrder;

    //Constructor 1
    public OrderItem(int id, int quantity, Product product) {
        this.orderitem_id = id;
        this.setQuantity(quantity);
        this.setProduct(product);
    }

    //Constructor 2
    public OrderItem(int quantity, Product product) {
        this(0,quantity,product);
    }

    //Empty Constructor
    public OrderItem() {}

    //Getters & Setters (sans SetID)
    public int getId() { return orderitem_id; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public ProductOrder getProductOrder() { return productOrder; }
    public void setProductOrder(ProductOrder productOrder) { this.productOrder = productOrder; }

    //Method to calculate Price
    public int calculateOrderPrice() {
        int result;
        result = (this.getProduct().getPrice() * this.getQuantity());
        return  result;
    }

    //Equals & Hashcode Override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return orderitem_id == orderItem.orderitem_id &&
                quantity == orderItem.quantity &&
                product.equals(orderItem.product);

    }

    @Override
    public int hashCode() {
        return Objects.hash(orderitem_id, quantity, product);
    }

    //ToString Override
    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + orderitem_id +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
