package com.javaacademy.shop_admin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NewShopPriceDto {
    private String name;
    @JsonProperty("shop_price")
    private String shopPrice;
}
