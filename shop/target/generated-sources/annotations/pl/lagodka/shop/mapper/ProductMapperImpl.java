package pl.lagodka.shop.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.lagodka.shop.model.dao.Product;
import pl.lagodka.shop.model.dao.Product.ProductBuilder;
import pl.lagodka.shop.model.dto.ProductDto;
import pl.lagodka.shop.model.dto.ProductDto.ProductDtoBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-06T16:58:49+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toDao(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        ProductBuilder product = Product.builder();

        product.id( productDto.getId() );
        product.name( productDto.getName() );
        if ( productDto.getPrice() != null ) {
            product.price( productDto.getPrice() );
        }
        product.quantity( productDto.getQuantity() );
        product.createdDate( productDto.getCreatedDate() );
        product.createdBy( productDto.getCreatedBy() );
        product.lastModifiedDate( productDto.getLastModifiedDate() );
        product.lastModifiedBy( productDto.getLastModifiedBy() );
        product.imageUrl( productDto.getImageUrl() );

        return product.build();
    }

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDtoBuilder productDto = ProductDto.builder();

        productDto.id( product.getId() );
        productDto.name( product.getName() );
        productDto.price( product.getPrice() );
        productDto.quantity( product.getQuantity() );
        productDto.createdDate( product.getCreatedDate() );
        productDto.createdBy( product.getCreatedBy() );
        productDto.lastModifiedDate( product.getLastModifiedDate() );
        productDto.lastModifiedBy( product.getLastModifiedBy() );
        productDto.imageUrl( product.getImageUrl() );

        return productDto.build();
    }
}
