package com.ing.nlsavings.domain;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private String name;
    private String city;
    private List<Car> cars;

    public Dealer(String name, String city, List<Car> cars) {
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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List cars) {
        this.cars = cars;
    }

    public void addCar(Car car){
        this.cars.add(car);
    }

    public void deleteCar(Car car){
        this.cars.remove(car);
    }
}
