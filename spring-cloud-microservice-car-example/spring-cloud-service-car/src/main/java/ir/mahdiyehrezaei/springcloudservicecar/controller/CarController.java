package ir.mahdiyehrezaei.springcloudservicecar.controller;

import ir.mahdiyehrezaei.springcloudservicecar.domain.CarInfo;
import ir.mahdiyehrezaei.springcloudservicecar.dto.CarDto;
import ir.mahdiyehrezaei.springcloudservicecar.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    CarRepository carRepository;

    @GetMapping("name/{name}/color/{color}") //price unit
    public CarDto getCarRequest(@PathVariable String name, @PathVariable String color){
        CarInfo carInfo = carRepository.findByNameContainingAndColorContaining(name, color);
        ModelMapper modelMapper = new ModelMapper();
        CarDto carDto = modelMapper.map(carInfo, CarDto.class);
        return new CarDto()
                .setName(name)
                .setColor(color)
                .setPrice(carDto.getPrice())
                .setBrand(carDto.getBrand())
                .setProductionYear(carDto.getProductionYear());
    }
}
