package com.javaacademy.shop_admin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopStatusDto {
    private String name;
    @JsonProperty("status")
    private String shopStatus;
    @JsonProperty("time_open")
    private String timeOpen;
    @JsonProperty("time_close")
    private String timeClose;
}
