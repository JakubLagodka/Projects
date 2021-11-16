package pl.lagodka.shop.mapper;

import pl.lagodka.shop.model.dao.Product;
import pl.lagodka.shop.model.dto.ProductDto;

public interface ProductMapper {
    Product toDao(ProductDto productDto);

    ProductDto toDto(Product product);
}
