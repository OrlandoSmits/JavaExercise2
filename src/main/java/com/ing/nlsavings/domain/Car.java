package com.ing.nlsavings.domain;

import java.util.UUID;

public class Car {

    private UUID uuid;

    private String name;

    private Brand brand;

    private Double price;

    public Car(String name, Brand brand, Double price) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
