package it.unipol.crm.anagrafica.gestione.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {

    private static final String TO_APPEND = "04";
    private static final Random RANDOM = new Random();

    public static BigInteger generateNewId() {
        return new BigInteger(String.valueOf(RANDOM.nextInt(10000))
            .concat(getSubstringFromCurrentMillisString(String.valueOf(System.currentTimeMillis()))
                .concat(TO_APPEND)));
    }

    private static String getSubstringFromCurrentMillisString(String currentMillisString) {
        return StringUtils.substring(currentMillisString,
            currentMillisString.length() - 12,
            currentMillisString.length());
    }
}
