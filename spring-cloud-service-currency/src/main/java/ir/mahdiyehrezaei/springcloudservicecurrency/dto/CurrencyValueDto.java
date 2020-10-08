package ir.mahdiyehrezaei.springcloudservicecurrency.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.objects.annotations.Property;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Component
public class CurrencyValueDto {
    private Integer id;
    private String from;
    private String to;
    @JsonIgnore
    private int port;
    private int currencyMultiplier;
}
