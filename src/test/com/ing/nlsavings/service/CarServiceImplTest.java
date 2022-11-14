package com.ing.nlsavings.service;

import com.ing.nlsavings.domain.Brand;
import com.ing.nlsavings.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceImplTest {

    private CarService carService;

    @BeforeEach
    public void beforeEach() {
        this.carService = new CarServiceImpl();
    }

    @Test
    void addCar() {
        Car car = this.insertOneCar();

        List<Car> allCars = carService.getAllCars();

        assertNotNull(allCars);
        assertEquals(1, allCars.size());
        assertNotNull(allCars.get(0));
        assertEquals(allCars.get(0).getName(), car.getName());
        assertEquals(allCars.get(0).getBrand(), car.getBrand());
        assertEquals(allCars.get(0).getPrice(), car.getPrice());
    }

    @Test
    void deleteCarById() {
        Car carOne = this.insertOneCar();
        Car carTwo = this.insertOneCar();

        carService.deleteCarById(carOne.getUuid());

        List<Car> allCars = carService.getAllCars();

        assertNotNull(allCars);
        assertEquals(1, allCars.size());
        assertNotNull(allCars.get(0));
        assertNotEquals(allCars.get(0).getUuid(), carOne.getUuid());
        assertEquals(allCars.get(0).getUuid(), carTwo.getUuid());
    }

    @Test
    void getCarById() {
        Car car = this.insertOneCar();

        Car result = carService.getCarById(car.getUuid());

        assertNotNull(result);
        assertEquals(result.getUuid(), car.getUuid());
    }

    @Test
    void getAllCars() {
        IntStream.range(0, 4).forEach(value -> this.insertOneCar());

        List<Car> allCars = carService.getAllCars();

        assertNotNull(allCars);
        assertEquals(4, allCars.size());
    }

    @Test
    void getCarsByBrand() {
        this.insertOneCar();

        List<Car> tesla = carService.getCarsByBrand("TESLA");

        assertNotNull(tesla);
        assertEquals(1, tesla.size());
        assertEquals(Brand.TESLA, tesla.get(0).getBrand());
    }

    private Car insertOneCar() {
        String carName = "Model X";
        Brand carBrand = Brand.TESLA;
        double carPrice = 45000.00;

        Car car = new Car(carName, carBrand, carPrice);

        carService.addCar(car);

        return car;
    }
}