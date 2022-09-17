package pl.lagodka.shop.service.impl

import org.springframework.data.domain.Pageable
import pl.lagodka.shop.model.dao.Template
import pl.lagodka.shop.repository.TemplateRepository
import spock.lang.Specification

class TemplateServiceImplSpec extends Specification{
    def templateRepository = Mock(TemplateRepository)
    def templateService = new TemplateServiceImpl(templateRepository)

    def 'should return template by id'() {
        given:
        def id = 1

        when:
        templateService.getById(id)

        then:
        1 * templateRepository.getById(id)
        0 * _
    }

    def 'should delete template'() {
        given:
        def id = 1

        when:
        templateService.delete(id)

        then:
        1 * templateRepository.deleteById(id)
        0 * _
    }

    def 'should return page of templates'() {
        given:
        def pageable = Mock(Pageable)

        when:
        templateService.getPage(pageable)

        then:
        1 * templateRepository.findAll(pageable)
        0 * _
    }

    def 'should save template'() {
        given:
        def template = Mock(Template)

        when:
        templateService.save(template)

        then:

        1 * templateRepository.save(template)
        0 * _
    }

    def 'should update template'() {
        given:
        def template = Mock(Template)
        def id = 1
        def templateDb = Mock(Template)

        when:
        templateService.update(template, id)

        then:
        1 * templateRepository.getById(id) >> templateDb
        1 * template.getName() >> "welcome"
        1 * templateDb.setName("welcome")
        1 * template.getBody() >> "template"
        1 * templateDb.setBody("template")
        1 * template.getSubject() >> "template"
        1 * templateDb.setSubject("template")
        0 * _
    }

}
