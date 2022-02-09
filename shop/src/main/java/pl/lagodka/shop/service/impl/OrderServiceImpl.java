package pl.lagodka.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.lagodka.shop.model.dao.Order;
import pl.lagodka.shop.repository.OrderRepository;
import pl.lagodka.shop.service.OrderService;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order, Long id) {
        Order orderDb = getById(id);
        orderDb.setOrderDetails(order.getOrderDetails());
        orderDb.setProduct(order.getProduct());
        orderDb.setQuantity(order.getQuantity());
        return orderDb;
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.getById(id);
    }

    @Override
    public Page<Order> getPage(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }
}
