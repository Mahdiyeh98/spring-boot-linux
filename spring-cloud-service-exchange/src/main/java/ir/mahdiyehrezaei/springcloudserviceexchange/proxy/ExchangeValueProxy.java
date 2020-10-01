package ir.mahdiyehrezaei.springcloudserviceexchange.proxy;

import ir.mahdiyehrezaei.springcloudserviceexchange.domain.ExchangeValue;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "spring-cloud-service-currency")
@RibbonClient
public interface ExchangeValueProxy {
    @GetMapping("currency/from/{from}/to/{to}")
    ExchangeValue getCurrency(@PathVariable String from,@PathVariable String to);
}
