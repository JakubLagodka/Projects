package pl.lagodka.shop.cotroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.lagodka.shop.mapper.ProductMapper;
import pl.lagodka.shop.model.dto.ProductDto;
import pl.lagodka.shop.service.ProductService;
import pl.lagodka.shop.validator.FileValid;
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
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "create new product", security = @SecurityRequirement(name = "bearer"))
    public ProductDto saveProduct(@Valid @RequestPart ProductDto productDto,  @RequestPart @Valid @FileValid MultipartFile image) {
        return productMapper.toDto(productService.create(productMapper.toDao(productDto), image));
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
    @Operation(description = "update given product", security = @SecurityRequirement(name = "bearer"))
    public ProductDto updateProduct(@Valid @RequestPart ProductDto productDto, @RequestPart @Valid @FileValid  MultipartFile image, @PathVariable Long id) {
        return productMapper.toDto(productService.update(productMapper.toDao(productDto), id, image));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "delete given product", security = @SecurityRequirement(name = "bearer"))
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }
}
