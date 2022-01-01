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

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;

    private final UserService userService;

    private final ProductService productService;

    @Override
    public void addProduct(Long productId, double quantity) {
        User currentUser = userService.getCurrentUser();
        basketRepository.findByProductIdAndUserId(productId, currentUser.getId())
                .ifPresentOrElse(basket -> {
                    basket.setQuantity(basket.getQuantity() + quantity);
                    basketRepository.save(basket);
                }, () ->  basketRepository.save(Basket.builder()
                        .product(productService.getById(productId))
                        .quantity(quantity)
                        .user(currentUser)
                        .build()));

    }

    @Override
    public List<Product> getBasket() {
        User currentUser = userService.getCurrentUser();
        List<Product> retBasket = new ArrayList<>();

        retBasket = basketRepository.findByUserId(currentUser.getId()).stream()
                .map(Basket::getProduct)
                .collect(Collectors.toList());
        return retBasket;

    }

    @Override
    @Transactional
    public void clearBasket() {
        User currentUser = userService.getCurrentUser();
        basketRepository.deleteByUserId(currentUser.getId());
    }

    @Override
    @Transactional
    public void deleteProductByProductId(Long productId) {
        User currentUser = userService.getCurrentUser();
        basketRepository.deleteByProductIdAndUserId(productId,currentUser.getId());
    }
}
