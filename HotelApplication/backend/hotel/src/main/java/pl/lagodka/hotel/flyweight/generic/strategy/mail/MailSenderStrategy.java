package pl.lagodka.hotel.flyweight.generic.strategy.mail;

import org.springframework.mail.MailSender;
import pl.lagodka.hotel.config.MailConfig;
import pl.lagodka.hotel.flyweight.generic.strategy.GenericStrategy;

public interface MailSenderStrategy extends GenericStrategy<MailSender> {
    byte[] sendMail(MailConfig mailConfig, String to, String subject, String text);
}
