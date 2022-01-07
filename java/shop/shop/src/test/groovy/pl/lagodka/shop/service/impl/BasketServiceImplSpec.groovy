package pl.lagodka.shop.service.impl

import pl.lagodka.shop.exception.NotEnoughProductQuantityException
import pl.lagodka.shop.model.dao.Product
import pl.lagodka.shop.model.dao.User
import pl.lagodka.shop.repository.BasketRepository
import pl.lagodka.shop.service.ProductService
import pl.lagodka.shop.service.UserService
import spock.lang.Specification

class BasketServiceImplSpec extends Specification{
    def basketRepository = Mock(BasketRepository)
    def userService = Mock(UserService)
    def productService = Mock(ProductService)
    def basketService = new BasketServiceImpl(basketRepository,userService,productService)

    def 'should throw exception when product quantity is not enough'(){
        given:
        def productId = 1
        def quantity = 5
        def currentUser = new User()
        userService.getCurrentUser() >> currentUser
        productService.getById(productId) >> new Product(quantity: 1)

        when:
        basketService.addProduct(productId,quantity)

        then:
        thrown NotEnoughProductQuantityException
    }
}
