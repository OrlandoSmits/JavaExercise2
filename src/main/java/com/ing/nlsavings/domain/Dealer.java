package com.ing.nlsavings.domain;

import java.util.List;

public class Dealer {
    private String name;
    private String city;
    private List<Car> cars;

    public Dealer(String name, String city, List cars) {
        this.name = name;
        this.city = city;
        this.cars = cars;
    }

    public Dealer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List getCars() {
        return cars;
    }

    public void setCars(List cars) {
        this.cars = cars;
    }
}
