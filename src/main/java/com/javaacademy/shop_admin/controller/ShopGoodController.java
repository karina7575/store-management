package com.javaacademy.shop_admin.controller;

import com.javaacademy.shop_admin.dto.GoodUpdatePriceStatusDto;
import com.javaacademy.shop_admin.dto.NewShopPriceDto;
import com.javaacademy.shop_admin.service.ShopGoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("shop/good")
@RequiredArgsConstructor
public class ShopGoodController {
    private final ShopGoodService shopGoodService;

    @PatchMapping
    public List<GoodUpdatePriceStatusDto> updateGoodPrice(@RequestBody NewShopPriceDto newShopPriceDto) {
        return shopGoodService.updatePricesForShops(newShopPriceDto);
    }
}
