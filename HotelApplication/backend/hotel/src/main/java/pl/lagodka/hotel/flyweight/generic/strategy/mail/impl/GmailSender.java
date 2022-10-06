package pl.lagodka.hotel.flyweight.generic.strategy.mail.impl;

//import lombok.extern.slf4j.Slf4j;
//import org.springframework.mail.MailSender;
//import org.springframework.stereotype.Component;
//import pl.lagodka.hotel.flyweight.generic.strategy.mail.MailSenderStrategy;
//import pl.lagodka.hotel.config.MailConfig;
//import pl.lagodka.hotel.flyweight.generic.strategy.mail.MailSenderStrategy;

import javax.mail.MessagingException;

//@Component
//@Slf4j
//public class GmailSender implements MailSenderStrategy {
//    @Override
//    public MailSender getType() {
//        return null;
//    }
//
//    @Override
//    public byte[] sendMail(MailConfig mailConfig, String to, String subject, String text) {
//        log.info("Sending mail");
//        try {
//            mailConfig.sendMail(to, subject, text,true);
//        } catch (MessagingException e) {
//            log.error("Failed to send mail", e);
//        }
//        return new byte[0];
//    }
//}
