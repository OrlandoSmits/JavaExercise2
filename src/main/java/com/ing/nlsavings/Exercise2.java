package com.ing.nlsavings;

import com.ing.nlsavings.domain.Brand;
import com.ing.nlsavings.domain.Car;
import com.ing.nlsavings.domain.Dealer;
import com.ing.nlsavings.service.CarDealerServiceImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Exercise2 {
    private CarDealerServiceImpl carDealerService;

    public void main(String[] args)  {
        carDealerService = new CarDealerServiceImpl();
        //Add dealer to the dealerlist
        CSV2Dealer();
    }

    private @NotNull Dealer insertOneDealer(String dealerName, String dealerCity) {

        List<Object> dealerCarsList = new ArrayList<>();
        Dealer dealer = new Dealer(dealerName,dealerCity, dealerCarsList);

        carDealerService.addDealer(dealer);

        return dealer;
    }

    private Car insertOneCar(String carName, Brand carBrand, double carPrice) {

        Car car = new Car(carName, carBrand, carPrice);

        carDealerService.getCarService().addCar(car);

        return car;
    }

    private void CSV2Dealer(){
        String line = "";
        String splitBy = ",";
        try {
            //parsing a dealer CSV file into BufferedReader class constructor

            BufferedReader br =
                    new BufferedReader(new FileReader("C:\\Users\\GH15QU\\Documents\\test\\dealer.csv"));
            while ((line = br.readLine()) != null)
            //returns a Boolean value
            {
                String[] dealerInput = line.split(splitBy);
                //use comma as separator
                String dealerInputName = dealerInput[0];
                String dealerInputCity = dealerInput[1];

                Dealer dealer = this.insertOneDealer(dealerInputName, dealerInputCity);
            }
        }

        catch(IOException e) {
            e.printStackTrace();
        }
    }
}

