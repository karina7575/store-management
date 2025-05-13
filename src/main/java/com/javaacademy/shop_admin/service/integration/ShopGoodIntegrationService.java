package com.javaacademy.shop_admin.service.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaacademy.shop_admin.dto.NewShopPriceDto;
import com.javaacademy.shop_admin.dto.ShopStatusIntegrationDto;
import com.javaacademy.shop_admin.exception.IntegrationException;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopGoodIntegrationService {
    private final OkHttpClient client;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void updateShopPrice(String url, String shopName, NewShopPriceDto newShopPriceDto) {
        Request request = new Request.Builder()
                .url(url)
                .patch(RequestBody.create(objectMapper.writeValueAsBytes(newShopPriceDto)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            @Cleanup Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                String message = "Не обновилась цена в магазине %s, вылетела ошибка с кодом %s. Обновление цен в других магазинах прервано!"
                        .formatted(shopName, response.code());
                throw new IntegrationException(message);
            }
        } catch (Exception e) {
            String message = "Не обновилась цена в магазине %s, вылетела ошибка с кодом %s"
                    .formatted(shopName, e.getMessage());
            throw new IntegrationException(message);
        }
    }
}
