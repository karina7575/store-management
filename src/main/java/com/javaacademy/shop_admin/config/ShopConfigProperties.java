package com.javaacademy.shop_admin.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "app.integration")
@Getter
@Setter
public class ShopConfigProperties {
    private List<Map<String, Object>> shops;
    private Map<String, Object> actionLinkPostfix;
}
