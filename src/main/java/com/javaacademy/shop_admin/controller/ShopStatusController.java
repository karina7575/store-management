package com.javaacademy.shop_admin.controller;

import com.javaacademy.shop_admin.service.ShopStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/status")
@RequiredArgsConstructor
public class ShopStatusController {
    private final ShopStatusService service;

    @GetMapping
    public ResponseEntity<?> getAllStatuses() {
        return ResponseEntity.ok(service.getAllStatuses());
    }
}
