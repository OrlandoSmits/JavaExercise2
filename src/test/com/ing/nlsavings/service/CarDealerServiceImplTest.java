package com.ing.nlsavings.service;

import com.ing.nlsavings.domain.Brand;
import com.ing.nlsavings.domain.Car;
import com.ing.nlsavings.domain.Dealer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarDealerServiceImplTest {

    private CarDealerServiceImpl carDealerService;

    @BeforeEach
    public void afterEach() {
        carDealerService = new CarDealerServiceImpl();
    }

    @Test
    void addDealer() {
        this.insertOneDealer();

        List<Dealer> allDealers = carDealerService.getAllDealers();

        assertNotNull(allDealers);
        assertEquals(1, allDealers.size());
    }

    @Test
    void addCarToDealer() {
        Dealer dealer = this.insertOneDealer();
        Car car = this.insertOneCar();

        carDealerService.addCarToDealer(dealer.getName(), car.getUuid());
        List<Car> allCarsFromDealer = carDealerService.getAllCarsFromDealer(dealer.getName());

        assertNotNull(allCarsFromDealer);
        assertEquals(1, allCarsFromDealer.size());
    }

    @Test
    void deleteCarFromDealer() {
        Dealer dealer = this.insertOneDealer();
        Car car = this.insertOneCar();

        carDealerService.addCarToDealer(dealer.getName(), car.getUuid());
        carDealerService.deleteCarFromDealer(car.getUuid(), dealer.getName());
        List<Car> allCarsFromDealer = carDealerService.getAllCarsFromDealer(dealer.getName());

        assertEquals(0, allCarsFromDealer.size());
    }

    @Test
    void getAllCarsFromDealer() {
        Dealer dealer = this.insertOneDealer();
        Car car = this.insertOneCar();

        carDealerService.addCarToDealer(dealer.getName(), car.getUuid());
        List<Car> allCarsFromDealer = carDealerService.getAllCarsFromDealer(dealer.getName());

        assertEquals(1, allCarsFromDealer.size());
    }

    @Test
    void getAllCarsFromSpecificDealer(){
        Dealer dealer01 = this.insertOneDealer();
        carDealerService.addDealer(dealer01);
        //Car car = this.insertOneCar();
        //carDealerService.addCarToDealer(dealer.getName(), car.getUuid());
        Dealer dealer02 = new Dealer("Louwman","Amsterdam", Collections.singletonList("null"));

        carDealerService.addDealer(dealer02);

        //Car car = this.insertOneCar();

        List<Dealer> oneDealer= carDealerService.getDealer("Louwman");
        assertNotNull(oneDealer);
        assertEquals(3, oneDealer.size());

    }

    private Dealer insertOneDealer() {
        String dealerName = "Van Mossel";
        String dealerCity = "Utrecht";
        List dealerCarsList = null;
        Dealer dealer = new Dealer(dealerName,dealerCity, dealerCarsList);

        carDealerService.addDealer(dealer);

        return dealer;
    }

    private Car insertOneCar() {
        String carName = "Model X";
        Brand carBrand = Brand.TESLA;
        double carPrice = 45000.00;

        Car car = new Car(carName, carBrand, carPrice);

        carDealerService.getCarService().addCar(car);

        return car;
    }
}