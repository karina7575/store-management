package com.javaacademy.shop_admin.service.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaacademy.shop_admin.dto.NewShopPriceDto;
import com.javaacademy.shop_admin.dto.ShopStatusIntegrationDto;
import com.javaacademy.shop_admin.exception.IntegrationException;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopStatusIntegrationService {
    private static final String SHOP_APP_IS_NOT_WORK = "ПРИЛОЖЕНИЕ НЕ РАБОТАЕТ!";
    private final OkHttpClient client;
    private final ObjectMapper objectMapper;

    public ShopStatusIntegrationDto getStatus(String url, String shopName) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try {
            @Cleanup Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                ShopStatusIntegrationDto shopStatusIntegrationDto = objectMapper.readValue(responseBody, ShopStatusIntegrationDto.class);
                return shopStatusIntegrationDto;
            }
        } catch (Exception ignored) {}
        return new ShopStatusIntegrationDto(shopName,
                SHOP_APP_IS_NOT_WORK,
                null,
                null);
    }

}
