package pl.lagodka.shop.flyweight.generic.strategy.mail.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Component;
import pl.lagodka.shop.flyweight.generic.strategy.mail.MailSenderStrategy;

@Component
@Slf4j
public class GmailSender implements MailSenderStrategy {
    @Override
    public MailSender getType() {
        return null;
    }

    @Override
    public byte[] sendMail() {
        log.info("Sending mail");
        return new byte[0];
    }
}
