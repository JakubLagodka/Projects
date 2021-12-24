package pl.lagodka.shop.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lagodka.shop.model.dto.BasketDto;
import pl.lagodka.shop.service.BasketService;

@RestController
@RequestMapping("/api/basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public void addProduct(@RequestBody BasketDto basketDto){
        basketService.addProduct(basketDto.getProductId(),basketDto.getQuantity());
    }
}
