package com.javaacademy.shop_admin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopStatusIntegrationDto {
    private String name;
    private String shopStatus;
    @JsonProperty("time_open")
    private String timeOpen;
    @JsonProperty("time_close")
    private String timeClose;
}
