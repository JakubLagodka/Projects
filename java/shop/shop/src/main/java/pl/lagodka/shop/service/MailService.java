package pl.lagodka.shop.service;

import javax.mail.MessagingException;

public interface MailService {

    void sendMail(String to, String templateName) ;
}
