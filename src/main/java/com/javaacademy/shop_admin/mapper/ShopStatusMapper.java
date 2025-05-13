package com.javaacademy.shop_admin.mapper;

import com.javaacademy.shop_admin.dto.ShopStatusDto;
import com.javaacademy.shop_admin.dto.ShopStatusIntegrationDto;
import org.springframework.stereotype.Service;

@Service
public class ShopStatusMapper {

    public ShopStatusDto toResponse(ShopStatusIntegrationDto integrationDto) {
        return ShopStatusDto.builder()
                .name(integrationDto.getName())
                .shopStatus(integrationDto.getShopStatus())
                .timeOpen(integrationDto.getTimeOpen())
                .timeClose(integrationDto.getTimeClose())
                .build();
    }
}
