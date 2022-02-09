package pl.lagodka.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lagodka.shop.model.dao.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {
}
