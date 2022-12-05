package com.ing.nlsavings.service;

import com.ing.nlsavings.domain.Brand;
import com.ing.nlsavings.domain.Car;
import com.ing.nlsavings.domain.Dealer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        Dealer dealer01 = this.insertOneDealer02("van Mossel", "Utrecht");
        //carDealerService.addDealer(dealer01);
        Car car11 = this.insertOneCar02("Model X", Brand.TESLA, 45000.00);
        // add 1 car to van Mossel
        carDealerService.addCarToDealer(dealer01.getName(), car11.getUuid());
        Car car12 = this.insertOneCar02("Model X", Brand.TESLA, 49000.00);
        carDealerService.addCarToDealer(dealer01.getName(), car12.getUuid());
        Car car13 = this.insertOneCar02("Twingo", Brand.RENAULT, 23845.00);
        carDealerService.addCarToDealer(dealer01.getName(), car13.getUuid());
        Car car14 = this.insertOneCar02("Zoe", Brand.RENAULT, 35150.00);
        carDealerService.addCarToDealer(dealer01.getName(), car14.getUuid());
        Car car15 = this.insertOneCar02("Zoe", Brand.RENAULT, 35750.00);
        carDealerService.addCarToDealer(dealer01.getName(), car15.getUuid());

        Dealer dealer02 = this.insertOneDealer02("Louwman","Amsterdam");
        carDealerService.addDealer(dealer02);

        Car car20 = this.insertOneCar02("Aygo X", Brand.TOYOTA, 22400.00);
        carDealerService.addCarToDealer(dealer02.getName(), car20.getUuid());
        Car car21 = this.insertOneCar02("Aygo X", Brand.TOYOTA, 22400.00);
        carDealerService.addCarToDealer(dealer02.getName(), car21.getUuid());
        Car car22 = this.insertOneCar02("Mustang Mach-e", Brand.FORD, 69900.00);
        carDealerService.addCarToDealer(dealer02.getName(), car22.getUuid());
        Car car23 = this.insertOneCar02("Mustang Mach-e", Brand.FORD, 69900.00);
        carDealerService.addCarToDealer(dealer02.getName(), car23.getUuid());
        Car car24 = this.insertOneCar02("Fiesta", Brand.FORD, 26950.00);
        carDealerService.addCarToDealer(dealer02.getName(), car24.getUuid());
        Car car25 = this.insertOneCar02("Puma", Brand.FORD, 45900.00);
        carDealerService.addCarToDealer(dealer02.getName(), car25.getUuid());

        Dealer oneDealer= carDealerService.getDealer("van Mossel");
        List<Car> allCarsFromDealer = carDealerService.getAllCarsFromDealer(oneDealer.getName());
        assertNotNull(oneDealer);
        assertEquals(5, allCarsFromDealer.size());

        Dealer twoDealer = carDealerService.getDealer("Louwman");
        List<Car> allCarsFromDealer2 = carDealerService.getAllCarsFromDealer(twoDealer.getName());
        assertNotNull(twoDealer);
        assertEquals(6, allCarsFromDealer2.size());
    }

    private Dealer insertOneDealer() {
        String dealerName = "Van Mossel";
        String dealerCity = "Utrecht";
        List dealerCarsList = new ArrayList<>();
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
    private Car insertOneCar02(String carName, Brand carBrand, double carPrice) {

        Car car = new Car(carName, carBrand, carPrice);

        carDealerService.getCarService().addCar(car);

        return car;
    }

    private Dealer insertOneDealer02(String dealerName, String dealerCity) {

        List dealerCarsList = new ArrayList<>();
        Dealer dealer = new Dealer(dealerName,dealerCity, dealerCarsList);

        carDealerService.addDealer(dealer);

        return dealer;
    }
}