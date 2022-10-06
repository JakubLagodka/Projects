package pl.lagodka.hotel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

//@Configuration
//public class MailConfig {
//
//    private final JavaMailSender javaMailSender;
//
//    @Autowired
//    public MailConfig(JavaMailSender javaMailSender) {
//        this.javaMailSender = javaMailSender;
//    }
//
//    public void sendMail(String to,
//                         String subject,
//                         String text,
//                         boolean isMailComponent) throws MessagingException {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//        mimeMessageHelper.setTo(to);
//        mimeMessageHelper.setSubject(subject);
//        mimeMessageHelper.setText(text, isMailComponent);
//        javaMailSender.send(mimeMessage);
//    }
//}
