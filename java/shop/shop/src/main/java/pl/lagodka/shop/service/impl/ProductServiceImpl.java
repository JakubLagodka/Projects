package pl.lagodka.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.lagodka.shop.model.dao.Product;
import pl.lagodka.shop.repository.ProductRepository;
import pl.lagodka.shop.service.ProductService;

import javax.transaction.Transactional;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @CachePut(cacheNames = "product", key = "#result.id")
    @Transactional
    public Product create(Product product, MultipartFile image) {
        return productRepository.save(product);
        Files.copy(image.getInputStream(), Paths.get("C:\\Users\\Kuba\\Desktop\\images\\" + product.getId() + "." + image.getOriginalFilename().))

    }

    @Override
    @CachePut(cacheNames = "product", key = "#result.id")
    public Product update(Product product, Long id) {
        Product productDB = getById(id);
        productDB.setName(product.getName());
        productDB.setAvailable(product.isAvailable());
        productDB.setPrice(product.getPrice());
        productDB.setQuantity(product.getQuantity());
        return productDB;
    }

    @Override
    @CacheEvict(cacheNames = "product", key = "#id")
    public void delete(Long id) {

        productRepository.deleteById(id);
    }

    @Override
    @Cacheable(cacheNames = "product", key = "#id")
    public Product getById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public Page<Product> getPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
