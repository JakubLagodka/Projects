package pl.lagodka.shop.mapper

import org.hibernate.envers.RevisionType
import org.springframework.data.history.RevisionMetadata
import pl.lagodka.shop.model.dao.Product
import pl.lagodka.shop.model.dto.ProductDto
import spock.lang.Specification

import java.time.LocalDateTime

class ProductMapperImplSpec extends Specification {
    def productMapper = new ProductMapperImpl()

    def 'should map product to productDto'() {
        given:
        def product = new Product(1, "pen", 9.99, true, 10,
                LocalDateTime.of(2022, 1, 6, 13, 30, 50), "kuba",
                LocalDateTime.of(2022, 1, 5, 12, 40, 50), "jan", "http:://https://m")

        when:
        def result = productMapper.toDto(product)

        then:
        result.id == product.id
        result.createdBy == product.createdBy
        result.createdDate == product.createdDate
        result.lastModifiedBy == product.lastModifiedBy
        result.lastModifiedDate == product.lastModifiedDate
        result.name == product.name
        result.price == product.price
        result.quantity == product.quantity
        result.imageUrl == product.imageUrl
    }

    def 'should map productDto to product'(){
        given:
        def productDto = new ProductDto(1, "pen", 9.99, true, 10,
                LocalDateTime.of(2022, 1, 6, 13, 30, 50), "Kuba",
                LocalDateTime.of(2022, 1, 5, 12, 40, 50), "Jan",
                RevisionMetadata.RevisionType.DELETE, 0,  "http:://https://m")

        when:
        def result = productMapper.toDao(productDto)

        then:
        result.id == productDto.id
        result.createdBy == productDto.createdBy
        result.createdDate == productDto.createdDate
        result.lastModifiedBy == productDto.lastModifiedBy
        result.lastModifiedDate == productDto.lastModifiedDate
        result.name == productDto.name
        result.price == productDto.price
        result.quantity == productDto.quantity
        result.imageUrl == productDto.imageUrl
    }

    def 'should map product to productDto return null'(){
        given:
        def product = null

        when:
        def result = productMapper.toDto(product)

        then:
        result == null
    }

    def 'should map productDto to product return null'(){
        given:
        def productDto = null

        when:
        def result = productMapper.toDao(productDto)

        then:
        result == null
    }
}
