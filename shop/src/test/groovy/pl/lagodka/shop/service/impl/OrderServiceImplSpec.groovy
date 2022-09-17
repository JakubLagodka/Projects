package pl.lagodka.shop.service.impl

import org.springframework.data.domain.Pageable
import pl.lagodka.shop.model.dao.Order
import pl.lagodka.shop.repository.OrderRepository
import spock.lang.Specification

class OrderServiceImplSpec extends Specification{
    def orderRepository = Mock(OrderRepository)
    def orderService = new OrderServiceImpl(orderRepository)

    def 'should return order by id'() {
        given:
        def id = 1

        when:
        orderService.getById(id)

        then:
        1 * orderRepository.getById(id)
        0 * _
    }

    def 'should delete order'() {
        given:
        def id = 1

        when:
        orderService.delete(id)

        then:
        1 * orderRepository.deleteById(id)
        0 * _
    }

    def 'should return page of orders'() {
        given:
        def pageable = Mock(Pageable)

        when:
        orderService.getPage(pageable)

        then:
        1 * orderRepository.findAll(pageable)
        0 * _
    }

    def 'should save order'() {
        given:
        def order = Mock(Order)

        when:
        orderService.create(order)

        then:

        1 * orderRepository.save(order)
        0 * _
    }

    def 'should update order'() {
        given:
        def order = Mock(Order)
        def id = 1
        def orderDb = Mock(Order)

        when:
        orderService.update(order, id)

        then:
        1 * orderRepository.getById(id) >> orderDb
        1 * order.getQuantity() >> 10.0
        1 * orderDb.setQuantity(10.0)
        1 * order.getOrderDetails()
        1 * orderDb.setOrderDetails(null)
        1 * order.getProduct()
        1 * orderDb.setProduct(null)
        0 * _
    }
}
