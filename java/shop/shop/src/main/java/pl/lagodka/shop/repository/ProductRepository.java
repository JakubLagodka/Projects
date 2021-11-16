package pl.lagodka.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lagodka.shop.model.dao.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
