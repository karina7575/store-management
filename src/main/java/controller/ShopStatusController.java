package controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ShopStatusService;

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
