package controller;

import dto.GoodUpdatePriceStatusDto;
import dto.NewShopPriceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ShopGoodService;

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
