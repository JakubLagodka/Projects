package pl.lagodka.shop.service.impl


import org.springframework.data.domain.Pageable
import org.springframework.web.multipart.MultipartFile
import pl.lagodka.shop.model.dao.Product
import pl.lagodka.shop.repository.ProductRepository
import spock.lang.Specification

class ProductServiceImplSpec extends Specification {
    def productRepository = Mock(ProductRepository)
    def productService = new ProductServiceImpl(productRepository)

    def 'should return product by id'() {
        given:
        def id = 1

        when:
        productService.getById(id)

        then:
        1 * productRepository.getById(id)
        0 * _
    }

    def 'should delete product'() {
        given:
        def id = 1

        when:
        productService.delete(id)

        then:
        1 * productRepository.deleteById(id)
        0 * _
    }

    def 'should return page of products'() {
        given:
        def pageable = Mock(Pageable)

        when:
        productService.getPage(pageable)

        then:
        1 * productRepository.findAll(pageable)
        0 * _
    }

//    def 'should create product'() {
//        given:
//        def product = Mock(Product)
//        def image = Mock(MultipartFile)
//
//        when:
//        productService.create(product, image)
//
//        then:
//        1 * productRepository.save(product)
//        1*product.getId()
//        0 * _
//    }
    def 'should update product'(){
        given:
        def product = Mock(Product)
        def id = 1

        when:
        productService.update(product, id)

        then:
        //1*productRepository.
    }
}
