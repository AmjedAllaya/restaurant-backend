package io.order.manager.food.order.manager.entities;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="Food_Order")
public class Food_Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="reference")
    private String reference;
    @Column(name="totalPrice")
    private long totalPrice;
    @Column(name="quantity")
    private int quantity;

    public Food_Order() {
    }

    public Food_Order(int id, String reference, long totalPrice, int quantity) {
        this.id = id;
        this.reference = reference;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Food_Order{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", totalPrice=" + totalPrice +
                ", quantity=" + quantity +
                '}';
    }
}
