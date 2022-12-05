package com.ing.nlsavings.service;

import com.ing.nlsavings.domain.Car;
import com.ing.nlsavings.domain.Dealer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarDealerServiceImpl implements CarDealerService {

    private final List<Dealer> dealers = new ArrayList<>();

    private final CarService carService = new CarServiceImpl();


    @Override
    public void addDealer(Dealer dealer) {
        this.dealers.add(dealer);
    }

    @Override
    public Dealer getDealer(String dealerName) {
        return this.dealers.stream()
                .filter(dealer -> dealer.getName().equalsIgnoreCase(dealerName))
                .findFirst()
                .orElse(null);

    }

    @Override
    public List<Dealer> getAllDealers() {
        return this.dealers;
    }

    @Override
    public void addCarToDealer(String dealerName, UUID carId) {
        // Use the carService to get a car. And add it to the dealer.
        Car carById = carService.getCarById(carId);
        Dealer addDealer = getDealer(dealerName);
        //this.dealers.add(addDealer.getName(),Dealer.getCity(), CarService.a(carId));
        addDealer.addCar(carById);
    }

    @Override
    public void deleteCarFromDealer(UUID carId, String dealerName) {
        Car carById = carService.getCarById(carId);
        Dealer deleteDealer = getDealer(dealerName);
        deleteDealer.deleteCar(carById);

    }

    @Override
    public List<Car> getAllCarsFromDealer(String dealerName) {
        Dealer dealerByName = getDealer(dealerName);
        return dealerByName.getCars();
    }

    // IMPORTANT! Normally it is not allowed to make the carService available like this.
    // In this fase we will do it like this. Later on we will introduce the mocking of services.
    public CarService getCarService() {
        return carService;
    }
}
