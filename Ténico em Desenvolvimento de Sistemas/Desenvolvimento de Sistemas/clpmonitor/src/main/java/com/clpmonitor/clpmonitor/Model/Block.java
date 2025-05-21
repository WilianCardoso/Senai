package com.clpmonitor.clpmonitor.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int position;

    private int color;

    @ManyToOne
    @JoinColumn(name = "StorageId")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name = "production_order_id") // FK para Orders.id
    private Orders productionOrder;

    // getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Orders getProductionOrder() {
        return productionOrder;
    }

    public void setProductionOrder(Orders productionOrder) {
        this.productionOrder = productionOrder;
    }
}