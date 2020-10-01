package ir.mahdiyehrezaei.springcloudserviceexchange.controller;

import ir.mahdiyehrezaei.springcloudserviceexchange.domain.ExchangeValue;
import ir.mahdiyehrezaei.springcloudserviceexchange.proxy.ExchangeValueProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exchange")
public class ExchangeController {

    @Autowired
    ExchangeValueProxy exchangeValueProxy;

    @GetMapping("from/{from}/to/{to}/quantity/{quantity}")
    public ExchangeValue getExchangeValue(@PathVariable String from,
                                          @PathVariable String to,
                                          @PathVariable int quantity) {
        ExchangeValue currency = exchangeValueProxy.getCurrency(from, to);
        return new ExchangeValue()
                .setId(currency.getId())
                .setFrom(from)
                .setTo(to)
                .setPort(currency.getPort())
                .setQuantity(quantity)
                .setCurrencyMultiplier(currency.getCurrencyMultiplier())
                .setCurrencyCalculate(quantity * currency.getCurrencyMultiplier());
    }
}
