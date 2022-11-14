package com.ing.nlsavings.service;

import com.ing.nlsavings.domain.Car;
import com.ing.nlsavings.domain.Dealer;

import java.util.List;
import java.util.UUID;

public interface CarDealerService {

    void addDealer(Dealer dealer);

    List<Dealer> getAllDealers();

    void addCarToDealer(String dealerName, UUID carId);

    void deleteCarFromDealer(UUID carId, String dealerName);

    List<Car> getAllCarsFromDealer(String dealerName);
}
