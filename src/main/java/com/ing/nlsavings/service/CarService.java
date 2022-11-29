package com.ing.nlsavings.service;

import com.ing.nlsavings.domain.Car;

import java.util.List;
import java.util.UUID;

public interface CarService {

    void addCar(Car car);

    void deleteCarById(UUID carId);

    void getCarById(UUID carId);

    List<Car> getAllCars();

    List<Car> getCarsByBrand(String brand);
}
