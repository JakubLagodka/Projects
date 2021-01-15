package pl.polsl.hotel.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailConfiguration {

    private JavaMailSender javaMailSender;

    @Autowired
    public MailConfiguration(JavaMailSender javaMailSender)
    {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String to,
                         String subject,
                         String text,
                         boolean isMailComponent) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text,isMailComponent);
        javaMailSender.send(mimeMessage);
    }
}
