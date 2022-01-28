package pl.lagodka.shop.flyweight.generic.strategy.mail;

import org.springframework.mail.MailSender;
import pl.lagodka.shop.flyweight.generic.strategy.GenericStrategy;

public interface MailSenderStrategy extends GenericStrategy<MailSender> {
    void sendMail(String to, String subject, String text);
}
