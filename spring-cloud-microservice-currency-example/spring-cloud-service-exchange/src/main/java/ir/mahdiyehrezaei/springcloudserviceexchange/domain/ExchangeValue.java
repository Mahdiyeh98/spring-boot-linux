package ir.mahdiyehrezaei.springcloudserviceexchange.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ExchangeValue {

    private Integer id;
    private String from;
    private String to;
    private int currencyMultiplier;
    private int port;
    private int quantity;
    private int currencyCalculate;
}
