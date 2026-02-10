package it.unipol.crm.anagrafica.gestione.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
@Slf4j
public class UserUtil {

    private static final String USER_ID_REGEXP = "uid=([\\w$]+)";
    private static final String DEFAULT_USER = "anagrafica-gestione";

    public String calculateUpdateUser(String principalName, String xApplicationId) {
        log.debug("Calculating update user, principalName: {}, xApplicationId: {}", principalName, xApplicationId);

        if (principalName == null) {
            log.warn("No principal name");
            return DEFAULT_USER;
        }

        var matcher = Pattern.compile(USER_ID_REGEXP).matcher(principalName);

        if (!matcher.find()) {
            log.warn("Not found uid in principal: {}", principalName);
            return DEFAULT_USER;
        }

        String userName = matcher.group(1);
        String updateUser = userName + "_" + xApplicationId;

        if (updateUser.length() > 20) {
            log.warn("Trimming update user: {}", updateUser);
            return updateUser.substring(0, 20);
        }

        log.debug("Returning updateUser: {}", updateUser);
        return updateUser;
    }
}