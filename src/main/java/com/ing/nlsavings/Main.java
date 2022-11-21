package com.ing.nlsavings;

import com.ing.nlsavings.domain.Brand;
import com.ing.nlsavings.domain.Car;
import com.ing.nlsavings.domain.Dealer;
import com.ing.nlsavings.service.CarDealerServiceImpl;

public class Main {

    public static void main(String[] args) {
        CarDealerServiceImpl cdsi = new CarDealerServiceImpl();

        cdsi.addDealer(new Dealer("Van Mossel", "Amsterdam"));
        cdsi.addDealer(new Dealer("Louwman", "Utrecht"));

        Car car;
        car = new Car("Model X", Brand.TESLA, 50.00);
        cdsi.getCarService().addCar(car);
        cdsi.addCarToDealer("Van Mossel", car.getUuid());

        car = new Car("Model Y", Brand.TESLA, 60.00);
        cdsi.getCarService().addCar(car);
        cdsi.addCarToDealer("Van Mossel", car.getUuid());

        car = new Car("Clio", Brand.RENAULT, 30.00);
        cdsi.getCarService().addCar(car);
        cdsi.addCarToDealer("Van Mossel", car.getUuid());

        car = new Car("Capture", Brand.RENAULT, 40.00);
        cdsi.getCarService().addCar(car);
        cdsi.addCarToDealer("Van Mossel", car.getUuid());

        car = new Car("Twingo", Brand.RENAULT, 50.00);
        cdsi.getCarService().addCar(car);
        cdsi.addCarToDealer("Van Mossel", car.getUuid());

        car = new Car("Yaris", Brand.TOYOTA, 20.00);
        cdsi.getCarService().addCar(car);
        cdsi.addCarToDealer("Louwman", car.getUuid());

        car = new Car("Aygo", Brand.TOYOTA, 15.00);
        cdsi.getCarService().addCar(car);
        cdsi.addCarToDealer("Louwman", car.getUuid());

        car = new Car("Focus", Brand.FORD, 20.00);
        cdsi.getCarService().addCar(car);
        cdsi.addCarToDealer("Louwman", car.getUuid());

        car = new Car("Kuga", Brand.FORD, 18.00);
        cdsi.getCarService().addCar(car);
        cdsi.addCarToDealer("Louwman", car.getUuid());

        car = new Car("Puma", Brand.FORD, 15.00);
        cdsi.getCarService().addCar(car);
        cdsi.addCarToDealer("Louwman", car.getUuid());

        car = new Car("Ka", Brand.FORD, 10.00);
        cdsi.getCarService().addCar(car);
        cdsi.addCarToDealer("Louwman", car.getUuid());

        System.out.println("---DEALERS---");
        for (Dealer dealer : cdsi.getAllDealers()) {
            System.out.println(dealer.getName());
        }

        System.out.println("\n");
        System.out.println("---CARS FROM VAN MOSSEL---");
        for (Car c : cdsi.getAllCarsFromDealer("Van Mossel")) {
            System.out.println("Van Mossel: " + c.toString());
        }
        System.out.println("\n");
        System.out.println("---CARS FROM LOUWMAN---");
        for (Car c : cdsi.getAllCarsFromDealer("Louwman")) {
            System.out.println("Louwman: " + c.toString());
        }

        System.out.println("\n");
        System.out.println("---AFTERE DELETE 1 CAR FROM LOUWMAN---");
        cdsi.deleteCarFromDealer(car.getUuid(), "Louwman");

        for (Car c : cdsi.getAllCarsFromDealer("Louwman")) {
            System.out.println("Louwman: " + c.toString());
        }

        System.out.println("\n");
        System.out.println("---DELETED CAR STILL EXISTS IN LIST WITH ALL CARS---");

        for (Car c : cdsi.getCarService().getAllCars()) {
            System.out.println("ALL cars: " + c.toString());
        }

        System.out.println("\n");
        System.out.println("---TOYOTA CARS---");

        for (Car c : cdsi.getCarService().getCarsByBrand("TOYOTA")) {
            System.out.println(c.toString());
        }
    }
}
