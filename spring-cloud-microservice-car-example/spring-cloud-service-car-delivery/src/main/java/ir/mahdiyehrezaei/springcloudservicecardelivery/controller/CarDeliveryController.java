package ir.mahdiyehrezaei.springcloudservicecardelivery.controller;

import ir.mahdiyehrezaei.springcloudservicecardelivery.domain.CarDelivery;
import ir.mahdiyehrezaei.springcloudservicecardelivery.proxy.CarDeliveryProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("car-delivery")
public class CarDeliveryController {

    @Autowired
    CarDeliveryProxy carDeliveryProxy;

    //localhost:8100/car-delivery/i8/
    @GetMapping("brand/{brand}/name/{name}/color/{color}/currency/{currency}/city/{city}")
    public CarDelivery getCarDelivery(@PathVariable String brand,
                                      @PathVariable String name,
                                      @PathVariable String color,
                                      @PathVariable String currency,
                                      @PathVariable String city) {

        CarDelivery carInfo = carDeliveryProxy.getCarInfo(brand, name, color);

        if (carInfo == null) {
            return new CarDelivery();
        }

        CarDelivery carDelivery = new CarDelivery();
        carDelivery.setBrand(brand)
                .setName(name)
                .setColor(color)
                .setCity(city)
                .setCurrency(currency);

        int exchangeCurrency = 0;
        int day = 0;

        if (currency.equals("rial")) {

            exchangeCurrency = 290000;
            if (city.equals("tehran") || city.equals("alborz")) {
                day = 32;
                carDelivery.setShippingFee(String.valueOf(15 * exchangeCurrency) + " rials ") // convert 15$ to rial
                        .setDay(day);
            } else if (city.equals("bandar abbas") || city.equals("hormozgan")) {
                day = 28;
                carDelivery.setShippingFee(String.valueOf(11 * exchangeCurrency) + " rails ")
                        .setDay(day);
            }
        } else if (currency.equals("inr")) {
            exchangeCurrency = 73;
            if (city.equals("delhi")) {
                day = 23;
                carDelivery.setShippingFee(String.valueOf(21 * exchangeCurrency) + " inr ")
                        .setDay(day);
            } else if (city.equals("punjab")) {
                day = 26;
                carDelivery.setShippingFee(String.valueOf(23 * exchangeCurrency) + " inr ")
                        .setDay(day);
            }
        }

        carDelivery.setCarPricesInYourCountry((String.valueOf(Integer.parseInt(carInfo.getPrice())*exchangeCurrency)) + " Rials")
                .setDeliveryTime(String.valueOf(day) + " days later.")
                .setPrice("$"+carInfo.getPrice());
        return carDelivery;
    }
}
