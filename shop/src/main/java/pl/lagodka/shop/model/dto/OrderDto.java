package pl.lagodka.shop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.lagodka.shop.model.dao.OrderDetails;
import pl.lagodka.shop.model.dao.Product;

import javax.persistence.ManyToOne;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderDto {
    private Long id;

    private Double quantity;

    @ManyToOne
    private OrderDetails orderDetails;

    @ManyToOne
    private Product product;
}
