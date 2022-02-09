package pl.lagodka.shop.service.impl

import pl.lagodka.shop.exception.NotEnoughProductQuantityException
import pl.lagodka.shop.model.dao.Basket
import pl.lagodka.shop.model.dao.Product
import pl.lagodka.shop.model.dao.User
import pl.lagodka.shop.repository.BasketRepository
import pl.lagodka.shop.service.ProductService
import pl.lagodka.shop.service.UserService
import spock.lang.Specification

class BasketServiceImplSpec extends Specification {
    def basketRepository = Mock(BasketRepository)
    def userService = Mock(UserService)
    def productService = Mock(ProductService)
    def basketService = new BasketServiceImpl(basketRepository, userService, productService)

    def 'should throw exception when product quantity is not enough'() {
        given:
        def productId = 1
        def quantity = 5
        def currentUser = new User()
        userService.getCurrentUser() >> currentUser
        productService.getById(productId) >> new Product(quantity: 1)

        when:
        basketService.addProduct(productId, quantity)

        then:
        thrown NotEnoughProductQuantityException
    }

    def 'should throw exception when product quantity is not enough to add to basket'() {
        given:
        def productId = 1
        def quantity = 5
        def currentUser = new User()
        def basket = new Basket(1, new User(), new Product(), 2.0)
        userService.getCurrentUser() >> currentUser
        productService.getById(productId) >> new Product(quantity: 5)
        basketRepository.findByProductIdAndUserId(productId, currentUser.getId()) >> Optional.of(basket)

        when:
        basketService.addProduct(productId, quantity)

        then:
        thrown NotEnoughProductQuantityException
    }

    def 'should add product to basket'() {
        given:
        def productId = 1
        def userId = 1
        def quantity = 1
        def currentUser = new User(id: userId)
        def basket = Mock(Basket)

        when:
        basketService.addProduct(productId, quantity)

        then:
        1 * userService.getCurrentUser() >> currentUser
        2 * productService.getById(productId) >> new Product(quantity: 5)
        1 * basketRepository.findByProductIdAndUserId(productId, userId) >> Optional.empty()
        1 * basketRepository.save(_ as Basket)
        0 * _
    }

    def 'should set more products in basket'() {
        given:
        def productId = 1
        def userId = 1
        def quantity = 1
        def currentUser = new User(id: userId)
        def basket = Mock(Basket)

        when:
        basketService.addProduct(productId, quantity)

        then:
        1 * userService.getCurrentUser() >> currentUser
        2 * productService.getById(productId) >> new Product(quantity: 5)
        1 * basketRepository.findByProductIdAndUserId(productId, userId) >> Optional.of(basket)
        2 * basket.getQuantity()
        1 * basket.setQuantity(1.0)
        1 * basketRepository.save(basket)
        0 * _
    }

    def 'should get basket'() {
        given:
        def userId = 1
        def currentUser = new User(id: userId)
        def basket = Mock(Basket)

        when:
        basketService.getBasket()

        then:
        1 * userService.getCurrentUser() >> currentUser
        1 * basketRepository.findByUserId(userId) >> Optional.of(basket)
        1 * basket.getProduct()
        0 * _
    }

    def 'should clear basket'() {
        given:
        def userId = 1
        def currentUser = new User(id: userId)

        when:
        basketService.clearBasket()

        then:
        1 * userService.getCurrentUser() >> currentUser
        1 * basketRepository.deleteByUserId(userId)
        0 * _
    }

    def 'should delete product by product id'() {
        given:
        def userId = 1
        def productId = 1
        def currentUser = new User(id: userId)

        when:
        basketService.deleteProductByProductId(productId)

        then:
        1 * userService.getCurrentUser() >> currentUser
        1 * basketRepository.deleteByProductIdAndUserId(productId, userId)
        0 * _
    }
}
