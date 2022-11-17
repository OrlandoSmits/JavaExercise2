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
    public List<Dealer> getAllDealers() {
        return this.dealers;
    }

    @Override
    public void addCarToDealer(String dealerName, UUID carId) {
        for (Dealer dealer : dealers) {
            if (dealer.getName().equals(dealerName)) {
                dealer.addCar(carService.getCarById(carId));
                break;
            }
        }
    }

    @Override
    public void deleteCarFromDealer(UUID carId, String dealerName) {
        for (Dealer dealer : dealers) {
            if (dealer.getName().equals(dealerName)) {
                dealer.removeCar(carService.getCarById(carId));
                break;
            }
        }
    }

    @Override
    public List<Car> getAllCarsFromDealer(String dealerName) {
        for (Dealer dealer : dealers) {
            if (dealer.getName().equals(dealerName)) {
                return dealer.getCars();
            }
        }
        return null;
    }

    // IMPORTANT! Normally it is not allowed to make the carService available like this.
    // In this fase we will do it like this. Later on we will introduce the mocking of services.
    public CarService getCarService() {
        return carService;
    }
}
