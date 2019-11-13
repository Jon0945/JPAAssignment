package se.lexicon.john.JPAAssignment.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;

public class ProductOrder {
    //Fields
    private int productorder_id;
    private LocalDateTime orderDateTime;
    private HashSet<OrderItem> products;
    private AppUser customer;

    //Constructor 1
    public ProductOrder(int productorder_id, LocalDateTime orderDateTime, AppUser customer) {
        this.productorder_id = productorder_id;
        this.setOrderDateTime(orderDateTime);
        this.products = new HashSet<>();
        this.setCustomer(customer);
    }

    //Constructor 2
    public ProductOrder(LocalDateTime orderDateTime, AppUser customer) {
        this(0,orderDateTime,customer);
    }

    //Empty Constructor
    public ProductOrder() {
    }

    //Getters & Setters
    public int getId() { return productorder_id; }
    public LocalDateTime getOrderDateTime() { return orderDateTime; }
    public void setOrderDateTime(LocalDateTime orderDateTime) { this.orderDateTime = orderDateTime; }
    public HashSet<OrderItem> getProductorder() { return products; }
    public AppUser getCustomer() { return customer; }
    public void setCustomer(AppUser customer) { this.customer = customer; }

    //Equals & Hashcode ovverride
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOrder that = (ProductOrder) o;
        return productorder_id == that.productorder_id &&
                orderDateTime.equals(that.orderDateTime) &&
                customer.equals(that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productorder_id, orderDateTime, customer);
    }

    //ToString override
    @Override
    public String toString() {
        return "ProductOrder{" +
                "productorder_id=" + productorder_id +
                ", orderDateTime=" + orderDateTime +
                ", customer=" + customer +
                '}';
    }

    public void addOrderItem(OrderItem orderItem) {
        this.products.add(orderItem);
        orderItem.setProductOrder(this);
    }


    public void removeOrderItem(OrderItem orderItem) {
        this.products.remove(orderItem);
        orderItem.setProductOrder(null);
    }

    public double calculateTotalOrderValue() {
        double ordervalue = products.stream()
                .mapToDouble(OrderItem::calculateOrderPrice)
                .sum();
        return ordervalue;
    }
}

