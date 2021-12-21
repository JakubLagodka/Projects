package pl.lagodka.shop.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.lagodka.shop.mapper.ProductMapper;
import pl.lagodka.shop.model.dto.ProductDto;
import pl.lagodka.shop.service.ProductService;
import pl.lagodka.shop.validator.group.Create;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/products")
@RequiredArgsConstructor
@Validated
public class ProductController {
    private final ProductService productService;

    private final ProductMapper productMapper;

    @PostMapping
    @Validated(Create.class)
    @PreAuthorize("hasRole('ADMIN')")
    public ProductDto saveProduct(@RequestBody @Valid ProductDto productDto) {
        return productMapper.toDto(productService.create(productMapper.toDao(productDto)));
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productMapper.toDto(productService.getById(id));
    }

    @GetMapping
    public Page<ProductDto> getProductPage(@RequestParam int page, @RequestParam int size) {
        return productService.getPage(PageRequest.of(page, size))
                .map(productMapper::toDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ProductDto updateProduct(@RequestBody @Valid ProductDto productDto, @PathVariable Long id) {
        return productMapper.toDto(productService.update(productMapper.toDao(productDto), id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }
}
