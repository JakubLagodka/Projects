package pl.lagodka.shop.mapper;

import org.mapstruct.Mapper;
import pl.lagodka.shop.model.dao.Product;
import pl.lagodka.shop.model.dto.ProductDto;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toDao(ProductDto productDto);

    ProductDto toDto(Product product);
}
