package com.ing.nlsavings.service;

import com.ing.nlsavings.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarServiceImpl implements CarService {

    List<Car> cars = new ArrayList<>();

    @Override
    public void addCar(Car car) {
        this.cars.add(car);
    }

    @Override
    public void deleteCarById(UUID carId) {
        this.cars.removeIf(car -> car.getUuid().equals(carId));
    }

    @Override
    public Car getCarById(UUID carId) {
        return this.cars.stream().filter(car -> car.getUuid().equals(carId)).findFirst().orElse(null);
    }

    @Override
    public List<Car> getAllCars() {
        return this.cars;
    }

    @Override
    public List<Car> getCarsByBrand(String brand) {
        return this.cars.stream()
                .filter(car -> car.getBrand().toString().equalsIgnoreCase(brand))
                .toList();
    }
}
