package pl.lagodka.shop.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;
import pl.lagodka.shop.model.dao.Template;
import pl.lagodka.shop.service.MailService;
import pl.lagodka.shop.service.TemplateService;

import java.util.Locale;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    private final TemplateService templateService;

    private final ITemplateEngine iTemplateEngine;

    @Async
    public void sendMail(String to, String templateName, Map<String,Object> variables)  {
        Template template = templateService.findByName(templateName);
        String body = iTemplateEngine.process(template.getBody(), new Context(Locale.getDefault(), variables));
        javaMailSender.send(mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(template.getSubject());
            mimeMessageHelper.setText(body, true);
        });
        log.info("email has been sent");
    }
}
