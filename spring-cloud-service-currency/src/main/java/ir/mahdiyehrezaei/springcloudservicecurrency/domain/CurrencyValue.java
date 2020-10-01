package ir.mahdiyehrezaei.springcloudservicecurrency.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class CurrencyValue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "currencyFrom")
    private String from;
    @Column(name = "currencyTo")
    private String to;
    private int currencyMultiplier;
}
