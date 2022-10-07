package pl.lagodka.shop.service.impl

import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.thymeleaf.ITemplateEngine
import org.thymeleaf.context.Context

import pl.lagodka.shop.model.dao.Template
import pl.lagodka.shop.service.TemplateService
import spock.lang.Specification

class MailServiceImplSpec extends Specification {
    def javaMailSender = Mock(JavaMailSender)
    def templateService = Mock(TemplateService)
    def iTemplateEngine = Mock(ITemplateEngine)
    def mailService = new MailServiceImpl(javaMailSender, templateService, iTemplateEngine)

    def "should send mail"() {
        given:
        def to = "admin@gmail.com"
        def templateName = "template"
        def variables = new HashMap<>()
        variables.put("firstName", "John")
        variables.put("lastName", "Smith")
        def template = new Template(id: 1, subject: "subject", name: "name", body: "body")
        def body = "body"
        def mimeMessageHelper = Mock(MimeMessageHelper)

        when:
        mailService.sendMail(to, templateName, variables as Map<String, Object>)

        then:
        1 * templateService.findByName('template') >> template
        1 * iTemplateEngine.process(template.getBody(), _ as Context) >> body
        1 * javaMailSender.send(mimeMessage -> {
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(template.getSubject());
            mimeMessageHelper.setText(body, true);
        })
        1 * mimeMessageHelper.setTo('admin@gmail.com')
        1 * mimeMessageHelper.setSubject('subject')
        1 * mimeMessageHelper.setText('body', true)
        0 * _
    }
}
