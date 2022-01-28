package pl.lagodka.shop.flyweight.generic.strategy.mail.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Component;
import pl.lagodka.shop.flyweight.generic.strategy.mail.MailSenderStrategy;
import pl.lagodka.shop.service.impl.MailService;

import javax.mail.MessagingException;

@Component
@Slf4j
@RequiredArgsConstructor
public class GmailSender implements MailSenderStrategy {
    private final MailService mailService;

    @Override
    public MailSender getType() {
        return null;
    }

    @Override
    public void sendMail(String to, String subject, String text) {
        log.info("Sending mail");
        try {
            mailService.sendMail(to, subject, text);
        } catch (MessagingException e) {
            log.error("Failed to send mail", e);
        }
    }
}
