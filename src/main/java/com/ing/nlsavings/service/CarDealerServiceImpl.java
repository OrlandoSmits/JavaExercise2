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
    public List<Dealer> getDealer(String dealerName) {
        return this.dealers;
    }

    @Override
    public List<Dealer> getAllDealers() {
        return this.dealers;
    }

    @Override
    public void addCarToDealer(String dealerName, UUID carId) {
        // Use the carService to get a car. And add it to the dealer.
        //Car carById = CarService.getCarById(carId);
        List<Dealer> addDealer = getDealer(dealerName);
        //this.dealers.add(addDealer.getName(),Dealer.getCity(), CarService.a(carId));
    }

    @Override
    public void deleteCarFromDealer(UUID carId, String dealerName) {

    }

    @Override
    public List<Car> getAllCarsFromDealer(String dealerName) {
        Dealer dealerByName = (Dealer) getDealer(dealerName);
        return (List<Car>) dealerByName;
    }

    // IMPORTANT! Normally it is not allowed to make the carService available like this.
    // In this fase we will do it like this. Later on we will introduce the mocking of services.
    public CarService getCarService() {
        return carService;
    }
}
