package pl.lagodka.shop.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.lagodka.shop.model.dao.Product;
import pl.lagodka.shop.model.dto.BasketDto;
import pl.lagodka.shop.service.BasketService;

import java.util.List;

@RestController
@RequestMapping("/api/basket")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class BasketController {
    private final BasketService basketService;

    @PostMapping
    public void addProduct(@RequestBody BasketDto basketDto) {
        basketService.addProduct(basketDto.getProductId(), basketDto.getQuantity());
    }

    @GetMapping
    public List<Product> getBasket() {
        return basketService.getBasket();
    }

    @DeleteMapping
    public void clearBasket() {
        basketService.clearBasket();
    }

    @DeleteMapping("/{productId}")
    public void deleteProductByProductId(@PathVariable Long productId) {
        basketService.deleteProductByProductId(productId);
    }
}
