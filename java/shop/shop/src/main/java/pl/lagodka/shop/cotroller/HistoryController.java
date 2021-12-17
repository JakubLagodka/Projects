package pl.lagodka.shop.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import pl.lagodka.shop.mapper.HistoryMapper;
import pl.lagodka.shop.model.dto.ProductDto;
import pl.lagodka.shop.model.dto.UserDto;
import pl.lagodka.shop.repository.ProductRepository;
import pl.lagodka.shop.repository.UserRepository;

@RestController
@RequestMapping("/api/histories")
@RequiredArgsConstructor
public class HistoryController {

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final HistoryMapper historyMapper;

    @GetMapping("/users/{id}")
    public Page<UserDto> getUserHistory(@PathVariable Long id, @RequestParam int page, @RequestParam int size){
        return userRepository.findRevisions(id, PageRequest.of(page, size))
                .map(historyMapper::toUserDto);
    }

    @GetMapping("/products/{id}")
    public Page<ProductDto> getProductHistory(@PathVariable Long id, @RequestParam int page, @RequestParam int size){
        return productRepository.findRevisions(id, PageRequest.of(page, size))
                .map(historyMapper::toProductDto);
    }
}