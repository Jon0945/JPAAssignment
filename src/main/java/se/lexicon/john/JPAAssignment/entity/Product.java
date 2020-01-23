package se.lexicon.john.JPAAssignment.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product {

    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productid;
    @Column(unique = true)
    private String productname;
    private int price;

    //Constructor 1
    public Product(int productid, String productname, int price) {
        this.productid = productid;
        this.setName(productname);
        this.setPrice(price);
    }

    //Constructor 2
    public Product(String productname, int price) {
        this(0, productname,price);
    }

    //Empty Constructor
    public Product() {}

    //Getters & Setters (sans SetID)
    public int getId() { return productid; }
    public String getName() { return productname; }
    public void setName(String name) { this.productname = name; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    //Hashcode & Equals Override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productid == product.productid &&
                price == product.price &&
                productname.equals(product.productname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productid, productname, price);
    }

    //ToString Override
    @Override
    public String toString() {
        return "Product{" +
                "id=" + productid +
                ", name='" + productname + '\'' +
                ", price=" + price +
                '}';
    }
}
