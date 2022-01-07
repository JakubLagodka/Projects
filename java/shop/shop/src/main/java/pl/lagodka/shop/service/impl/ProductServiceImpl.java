package pl.lagodka.shop.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @CachePut(cacheNames = "product", key = "#result.id")
    @Transactional
    public Product create(Product product, MultipartFile image) {
         productRepository.save(product);
        try {
            Path path = Paths.get("C:\\Users\\Kuba\\Desktop\\images\\" + product.getId() + "." + image.getOriginalFilename().toLowerCase());
            Files.copy(image.getInputStream(),path );
            product.setImageUrl(path.toString());
        } catch (IOException e) {
            log.error("Failed to save file", e);
        }
        return product;
    }

    @Override
    @CachePut(cacheNames = "product", key = "#result.id")
    public Product update(Product product, Long id) {
        Product productDb = getById(id);
        productDb.setName(product.getName());
        productDb.setAvailable(product.isAvailable());
        productDb.setPrice(product.getPrice());
        productDb.setQuantity(product.getQuantity());
        return productDb;
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
