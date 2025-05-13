package com.javaacademy.shop_admin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GoodUpdatePriceStatusDto {
    @JsonProperty("shop_name")
    private String shopName;
    private String status;
}
