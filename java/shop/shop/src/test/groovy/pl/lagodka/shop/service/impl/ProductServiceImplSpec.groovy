package pl.lagodka.shop.service.impl

import org.apache.commons.io.FilenameUtils
import org.springframework.data.domain.Pageable
import org.springframework.web.multipart.MultipartFile
import pl.lagodka.shop.helper.FileHelper
import pl.lagodka.shop.model.dao.Product
import pl.lagodka.shop.repository.ProductRepository
import spock.lang.Specification

import java.nio.file.Paths

class ProductServiceImplSpec extends Specification {
    def productRepository = Mock(ProductRepository)
    def fileHelper = Mock(FileHelper)
    def productService = new ProductServiceImpl(productRepository, fileHelper)

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

    def 'should save product'() {
        given:
        def product = Mock(Product)
        def image = Mock(MultipartFile)
        def path = Paths.get("C:\\Users\\Kuba\\Desktop\\images\\1.png")
        def inputStream = Mock(InputStream)


        when:
        productService.create(product, image)

        then:
        1 * productRepository.save(product)
        1 * product.getId() >> 1
        1 * image.getOriginalFilename() >> "file.png"
        1 * image.getInputStream() >> inputStream
        1 * fileHelper.saveFile(inputStream, path)
        1 * product.setImageUrl("C:\\Users\\Kuba\\Desktop\\images\\1.png");
        0 * _
    }

    def 'should save product without file'() {
        given:
        def product = Mock(Product)
        def image = Mock(MultipartFile)
        def path = Paths.get("C:\\Users\\Kuba\\Desktop\\images\\1.png")
        def inputStream = Mock(InputStream)


        when:
        productService.create(product, image)

        then:
        1 * productRepository.save(product)
        1 * product.getId() >> 1
        1 * image.getOriginalFilename() >> "file.png"
        1 * image.getInputStream() >> inputStream
        1 * fileHelper.saveFile(inputStream, path) >> {throw new IOException()}
        0 * _
    }

    def 'should update product'() {
        given:
        def product = Mock(Product)
        def productDb = Mock(Product)
        def id = 1
        def image = Mock(MultipartFile)
        def path = Paths.get("C:\\Users\\Kuba\\Desktop\\images\\1.png")
        def inputStream = Mock(InputStream)

        when:
        productService.update(product, id,image)

        then:
        1 * productRepository.getById(id) >> productDb
        1 * product.getName() >> "pen"
        1 * productDb.setName("pen");
        1 * product.isAvailable() >> true
        1 * productDb.setAvailable(true);
        1 * product.getPrice() >> 9.99
        1 * productDb.setPrice(9.99);
        1 * product.getQuantity() >> 10
        1 * productDb.setQuantity(10);
        1 * product.getId() >> 1
        1 * image.getOriginalFilename() >> "file.png"
        1 * image.getInputStream() >> inputStream
        1 * fileHelper.saveFile(inputStream, path)
        1 * product.setImageUrl("C:\\Users\\Kuba\\Desktop\\images\\1.png");
        0 * _
    }

    def 'should update product without file'() {
        given:
        def product = Mock(Product)
        def productDb = Mock(Product)
        def id = 1
        def image = Mock(MultipartFile)
        def path = Paths.get("C:\\Users\\Kuba\\Desktop\\images\\1.png")
        def inputStream = Mock(InputStream)


        when:
        productService.update(product, id, image)

        then:
        1 * productRepository.getById(id) >> productDb
        1 * product.getName() >> "pen"
        1 * productDb.setName("pen");
        1 * product.isAvailable() >> true
        1 * productDb.setAvailable(true);
        1 * product.getPrice() >> 9.99
        1 * productDb.setPrice(9.99);
        1 * product.getQuantity() >> 10
        1 * productDb.setQuantity(10);
        1 * product.getId() >> 1
        1 * image.getOriginalFilename() >> "file.png"
        1 * image.getInputStream() >> inputStream
        1 * fileHelper.saveFile(inputStream, path) >> {throw new IOException()}
        0 * _
    }
}
