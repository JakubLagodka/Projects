package pl.lagodka.shop.mapper

import org.springframework.data.history.Revision
import pl.lagodka.shop.model.dao.Product
import pl.lagodka.shop.model.dao.User
import spock.lang.Specification

class HistoryMapperImplSpec extends Specification{
    def historyMapper = new HistoryMapperImpl()

    def 'should map Revision<Integer, User> to userDto'(){
        given:
        def revision = new Revision<Integer, User>()

        when:
        def result = historyMapper.toUserDto(revision)

        then:
        result.id == revision.getEntity().getId()
        result.confirmPassword == null
        result.createdBy == null
        result.createdDate == null
        result.firstName == revision.getEntity().getFirstName()
        result.lastModifiedBy == null
        result.lastModifiedDate == null
        result.lastName == revision.getEntity().getLastName()
        result.login == revision.getEntity().getLogin()
        result.mail == revision.getEntity().getMail()
        result.password == null
        result.revisionNumber == revision.getRequiredRevisionNumber()
        result.revisionType == revision.getMetadata().getRevisionType()

    }

    def 'should map Revision<Integer, Product> to productDto'(){
        given:
        def revision = new Revision<Integer, Product>()

        when:
        def result = historyMapper.toProductDto(revision)

        then:
        result.id == revision.getEntity().getId()
        result.createdBy == null
        result.createdDate == null
        result.lastModifiedBy == null
        result.lastModifiedDate == null
        result.name == revision.getEntity().getName()
        result.price == revision.getEntity().getPrice()
        result.quantity == 0
        result.imageUrl == null
        result.available == revision.getEntity().isAvailable()
        result.revisionNumber == revision.getRequiredRevisionNumber()
        result.revisionType == revision.getMetadata().getRevisionType()

    }
    def 'should map revision to productDto return null'(){
        given:
        def revision = null

        when:
        def result = historyMapper.toProductDto(revision)

        then:
        result == null
    }

    def 'should map revision to userDto return null'(){
        given:
        def revision = null

        when:
        def result = historyMapper.toUserDto(revision)

        then:
        result == null
    }

}
