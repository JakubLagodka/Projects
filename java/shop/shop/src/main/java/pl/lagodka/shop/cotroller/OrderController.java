package pl.lagodka.shop.cotroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.lagodka.shop.mapper.OrderMapper;
import pl.lagodka.shop.model.dto.OrderDto;
import pl.lagodka.shop.service.OrderService;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class OrderController {
    private final OrderService orderService;

    private final OrderMapper orderMapper;

    @PostMapping
    @Operation(description = "create new order", security = @SecurityRequirement(name = "bearer"))
    public OrderDto saveOrder(@RequestBody OrderDto orderDto) {
        return orderMapper.toDto(orderService.create(orderMapper.toDao(orderDto)));
    }

    @GetMapping("/{id}")
    @Operation(description = "get order by given id", security = @SecurityRequirement(name = "bearer"))
    public OrderDto getOrderById(@PathVariable Long id) {
        return orderMapper.toDto(orderService.getById(id));
    }

    @GetMapping
    @Operation(description = "get all orders", security = @SecurityRequirement(name = "bearer"))
    public Page<OrderDto> getOrderPage(@RequestParam int page, @RequestParam int size) {
        return orderService.getPage(PageRequest.of(page, size))
                .map(orderMapper::toDto);
    }

    @PutMapping("/{id}")
    @Operation(description = "update given order", security = @SecurityRequirement(name = "bearer"))
    public OrderDto updateOrder(@RequestBody OrderDto orderDtoDto, @PathVariable Long id) {
        return orderMapper.toDto(orderService.update(orderMapper.toDao(orderDtoDto), id));
    }

    @DeleteMapping("/{id}")
    @Operation(description = "delete given order", security = @SecurityRequirement(name = "bearer"))
    public void deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
    }
}
