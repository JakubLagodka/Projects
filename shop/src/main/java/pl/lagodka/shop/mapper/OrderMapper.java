package pl.lagodka.shop.mapper;

import org.mapstruct.Mapper;
import pl.lagodka.shop.model.dao.Order;
import pl.lagodka.shop.model.dto.OrderDto;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toDao(OrderDto orderDto);

    OrderDto toDto(Order order);
}
