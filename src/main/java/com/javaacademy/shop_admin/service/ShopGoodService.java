package com.javaacademy.shop_admin.service;

import com.javaacademy.shop_admin.config.ShopConfigProperties;
import com.javaacademy.shop_admin.dto.GoodUpdatePriceStatusDto;
import com.javaacademy.shop_admin.dto.NewShopPriceDto;
import com.javaacademy.shop_admin.dto.ShopStatusDto;
import com.javaacademy.shop_admin.dto.ShopStatusIntegrationDto;
import com.javaacademy.shop_admin.mapper.ShopStatusMapper;
import com.javaacademy.shop_admin.service.integration.ShopGoodIntegrationService;
import com.javaacademy.shop_admin.service.integration.ShopStatusIntegrationService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShopGoodService {
    private final ShopGoodIntegrationService shopGoodIntegrationService;
    private final ShopConfigProperties shopConfigProperties;


    public List<GoodUpdatePriceStatusDto> updatePricesForShops(NewShopPriceDto newPriceDto) {
        return shopConfigProperties.getShops().stream()
                .map(shop -> updatePriceForShop(shop, newPriceDto))
                .toList();
    }

    private GoodUpdatePriceStatusDto updatePriceForShop(Map<String, Object> shopMap,
                                                        NewShopPriceDto newPriceDto) {
        Map<String, String> shop = (Map<String, String>) shopMap.get("shop");
        String baseAppUrl = shop.get("url");
        String shopName = shop.get("name");
        String url = "%s%s".formatted(baseAppUrl, shopConfigProperties.getActionLinkPostfix()
                .get("update-price"));
        try {
            shopGoodIntegrationService.updateShopPrice(url, shopName, newPriceDto);
            return new GoodUpdatePriceStatusDto(shopName, "Цена обновилась успешно");
        } catch (Exception e) {
            return new GoodUpdatePriceStatusDto(shopName, e.getMessage());
        }
    }
}
