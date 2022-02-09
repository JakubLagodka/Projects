package pl.lagodka.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lagodka.shop.model.dao.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
