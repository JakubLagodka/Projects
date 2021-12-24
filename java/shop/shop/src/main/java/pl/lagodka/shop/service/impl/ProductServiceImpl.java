package pl.lagodka.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.lagodka.shop.model.dao.Product;
import pl.lagodka.shop.repository.ProductRepository;
import pl.lagodka.shop.service.ProductService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product, Long id) {
        Product productDB = getById(id);
        productDB.setName(product.getName());
        productDB.setAvailable(product.isAvailable());
        productDB.setPrice(product.getPrice());
        productDB.setQuantity(product.getQuantity());
        return productDB;
    }

    @Override
    public void delete(Long id) {

        productRepository.deleteById(id);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public Page<Product> getPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
