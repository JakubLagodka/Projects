package pl.lagodka.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.lagodka.shop.model.dao.Basket;
import pl.lagodka.shop.model.dao.Product;
import pl.lagodka.shop.model.dao.User;
import pl.lagodka.shop.repository.BasketRepository;
import pl.lagodka.shop.service.BasketService;
import pl.lagodka.shop.service.ProductService;
import pl.lagodka.shop.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;

    private final UserService userService;

    private final ProductService productService;

    @Override
    public void addProduct(Long productId, Double quantity) {
        User currentUser = userService.getCurrentUser();
        basketRepository.findByProductIdAndUserId(productId, currentUser.getId())
                .ifPresentOrElse(basket -> basket.setQuantity(basket.getQuantity() + quantity), () -> Basket.builder()
                        .product(productService.getById(productId))
                        .quantity(quantity)
                        .user(currentUser)
                        .build());
    }

    @Override
    public List<Product> getBasket() {
        return null;
    }

    @Override
    public void clearBasket() {

    }

    @Override
    public void deleteProductById(Long id) {

    }
}
