package pl.lagodka.shop.service.impl

import pl.lagodka.shop.repository.OrderRepository
import spock.lang.Specification

class OrderServiceImplSpec extends Specification{
    def orderRepository = Mock(OrderRepository)
    def orderService = new OrderServiceImpl(orderRepository)
}
