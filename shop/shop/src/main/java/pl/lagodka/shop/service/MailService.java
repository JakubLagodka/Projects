package pl.lagodka.shop.service;

import java.util.Map;

public interface MailService {

    void sendMail(String to, String templateName, Map<String, Object> variables);
}
