package ir.mahdiyehrezaei.springcloudservicecurrency.controller;

import ir.mahdiyehrezaei.springcloudservicecurrency.domain.CurrencyValue;
import ir.mahdiyehrezaei.springcloudservicecurrency.dto.CurrencyValueDto;
import ir.mahdiyehrezaei.springcloudservicecurrency.repository.CurrencyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("currency")
public class CurrencyController {

    @Autowired
    CurrencyValueDto currencyValueDto;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    Environment environment;

    @GetMapping("from/{from}/to/{to}")
    public CurrencyValueDto getCurrencyValue(@PathVariable String from, @PathVariable String to) {
        CurrencyValue currencyValue = currencyRepository.findByFromContainingAndToContaining(from, to);
        ModelMapper modelMapper = new ModelMapper();
        currencyValueDto = modelMapper.map(currencyValue, CurrencyValueDto.class);
        currencyValueDto.setPort(Integer.parseInt(environment.getProperty("server.port")));
        currencyValueDto.setCurrencyMultiplier(currencyValue.getCurrencyMultiplier());
        return currencyValueDto;
    }
}
