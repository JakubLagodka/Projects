package pl.lagodka.shop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.lagodka.shop.model.dao.Product;

public interface ProductService {
    Product create(Product product);

    Product update(Product product, Long id);

    void delete(Long id);

    Product getById(Long id);

    Page<Product> getPage(Pageable pageable);
}
