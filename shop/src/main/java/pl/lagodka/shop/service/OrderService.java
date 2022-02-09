package pl.lagodka.shop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.lagodka.shop.model.dao.Order;

public interface OrderService {
    Order create(Order order);

    Order update(Order order, Long id);

    void delete(Long id);

    Order getById(Long id);

    Page<Order> getPage(Pageable pageable);
}
