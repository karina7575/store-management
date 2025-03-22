package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class GoodUpdatePriceStatusDto {
    @JsonProperty("shop_name")
    private String shopName;
    private String status;
}
