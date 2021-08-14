package pl.lagodka.hotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RequiredArgsConstructor
@Service
public class MailService {

    private final JavaMailSender javaMailSender;


    public void sendMail(String to, String subject, String text, boolean isMailComponent) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setReplyTo("programistakuba@gmail.com");
        mimeMessageHelper.setFrom("programistakuba@gmail.com");
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text, isMailComponent);
        javaMailSender.send(mimeMessage);
    }
}
