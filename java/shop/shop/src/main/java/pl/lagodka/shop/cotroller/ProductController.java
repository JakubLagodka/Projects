package pl.lagodka.shop.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import pl.lagodka.shop.mapper.ProductMapper;
import pl.lagodka.shop.model.dto.ProductDto;
import pl.lagodka.shop.service.ProductService;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    private final ProductMapper productMapper;

    @PostMapping
    public ProductDto saveUser(@RequestBody ProductDto productDto) {
        return productMapper.toDto(productService.create(productMapper.toDao(productDto)));
    }

    @GetMapping("/{id}")
    public ProductDto getUserById(@PathVariable Long id) {
        return productMapper.toDto(productService.getById(id));
    }

    @GetMapping
    public Page<ProductDto> getUserPage(@RequestParam int page, @RequestParam int size) {
        return productService.getPage(PageRequest.of(page, size))
                .map(productMapper::toDto);
    }

    @PutMapping("/{id}")
    public ProductDto updateUser(@RequestBody ProductDto productDto, @PathVariable Long id) {
        return productMapper.toDto(productService.update(productMapper.toDao(productDto), id));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        productService.delete(id);
    }
}
