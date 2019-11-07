package se.lexicon.john.JPAAssignment.entity;

import java.util.Objects;

public class OrderItem {

    //Fields
    private int id;
    private int quantity;
    private Product product;
    private ProductOrder productOrder;

    //Constructor 1
    public OrderItem(int id, int quantity, Product product, ProductOrder productOrder) {
        this.id = id;
        this.setQuantity(quantity);
        this.setProduct(product);
        this.setProductOrder(productOrder);
    }

    //Constructor 2
    public OrderItem(int quantity, Product product, ProductOrder productOrder) {
        this(0,quantity,product,productOrder);
    }

    //Empty Constructor
    public OrderItem() {}

    //Getters & Setters (sans SetID)
    public int getId() { return id; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public ProductOrder getProductOrder() { return productOrder; }
    public void setProductOrder(ProductOrder productOrder) { this.productOrder = productOrder; }

    //Method to calculate Price
    public int calculateOrderPrice() {
        return (product.getPrice() * quantity);
    }

    //Equals & Hashcode Override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return id == orderItem.id &&
                quantity == orderItem.quantity &&
                product.equals(orderItem.product) &&
                productOrder.equals(orderItem.productOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, product, productOrder);
    }

    //ToString Override
    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                ", productOrder=" + productOrder +
                '}';
    }
}
