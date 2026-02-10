package it.unipol.crm.sinistro.config;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);

        errorAttributes.keySet().removeIf(key -> !key.equals("message"));

        // substitute "message" with "messaggioErrore"
        final Object message = errorAttributes.remove("message");
        errorAttributes.put("messaggioErrore", message);

        return errorAttributes;
    }
}