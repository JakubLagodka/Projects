package pl.lagodka.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.lagodka.shop.model.dao.Template;
import pl.lagodka.shop.service.MailService;
import pl.lagodka.shop.service.TemplateService;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    private final TemplateService templateService;

    public void sendMail(String to, String templateName)  {
        Template template = templateService.findByName(templateName);
        javaMailSender.send(mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(template.getSubject());
            mimeMessageHelper.setText(template.getBody(), true);
        });
    }
}
