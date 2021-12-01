//package pl.lagodka.shop.mapper.impl;
//
//import org.springframework.stereotype.Component;
//import pl.lagodka.shop.mapper.ProductMapper;
//import pl.lagodka.shop.model.dao.Product;
//import pl.lagodka.shop.model.dto.ProductDto;
//
//@Component
//public class ProductMapperImpl implements ProductMapper {
//    @Override
//    public Product toDao(ProductDto productDto) {
//        return Product.builder()
//                .name(productDto.getName())
//                .price(productDto.getPrice())
//                .isAvailable(productDto.isAvailable())
//                .build();
//    }
//
//    @Override
//    public ProductDto toDto(Product product) {
//        return ProductDto.builder()
//                .name(product.getName())
//                .price(product.getPrice())
//                .isAvailable(product.isAvailable())
//                .build();
//    }
//}
