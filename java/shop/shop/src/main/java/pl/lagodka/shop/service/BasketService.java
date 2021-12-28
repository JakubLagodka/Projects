package pl.lagodka.shop.service;

import pl.lagodka.shop.model.dao.Product;

import java.util.List;

public interface BasketService {

    void addProduct(Long productId, Double quantity);

    List<Product> getBasket();

    void clearBasket();

    void deleteProductByProductId(Long id);

}
