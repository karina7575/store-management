package service;

import config.ShopConfigProperties;
import dto.ShopStatusDto;
import dto.ShopStatusIntegrationDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mapper.ShopStatusMapper;
import org.springframework.stereotype.Service;
import service.integration.ShopStatusIntegrationService;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShopStatusService {
    private final ShopStatusMapper shopStatusMapper;
    private final ShopStatusIntegrationService shopStatusIntegrationService;
    private final ShopConfigProperties shopConfigProperties;

    @SneakyThrows
    public List<ShopStatusDto> getAllStatuses() {
        return shopConfigProperties.getShops().stream()
                .map(this::getShopStatus)
                .toList();
    }



    private ShopStatusDto getShopStatus(Map<String, Object> shopMap) {
        Map<String, String> shop = (Map<String, String>) shopMap.get("shop");
        String baseAppUrl = shop.get("url");
        String shopName = shop.get("name");
        String url = "%s%s".formatted(baseAppUrl, shopConfigProperties.getActionLinkPostfix().get("get-status"));

        ShopStatusIntegrationDto integrationDto = shopStatusIntegrationService
                .getStatus(url, shopName);
        return shopStatusMapper.toResponse(integrationDto);
    }
}