package it.unipol.crm.sinistro.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserUtilTest {

    @Autowired
    UserUtil userUtil;

    @Test
    void shouldCalculateUpdateUserForValidPrincipalName() {

        // given
        String givenPrincipalName = "uid=101853$1";
        String givenAppId = "sampleAppId";
        String expectedUpdateUser = "101853$1_sampleAppId";

        // when
        final String givenUpdateUser = userUtil.calculateUpdateUser(givenPrincipalName, givenAppId);

        // then
        assertEquals(expectedUpdateUser, givenUpdateUser);
    }

    @Test
    void shouldReturnDefaultUserForNullPrincipalName() {

        // given
        String givenAppId = "sampleAppId";
        String expectedUpdateUser = "sinistri-gestione";

        // when
        final String givenUpdateUser = userUtil.calculateUpdateUser(null, givenAppId);

        // then
        assertEquals(expectedUpdateUser, givenUpdateUser);
    }

    @Test
    void shouldReturnDefaultUserWhenMatcherFailed() {

        // given
        String givenPrincipalName = "samp";
        String givenAppId = "sampleAppId";
        String expectedUpdateUser = "sinistri-gestione";

        // when
        final String givenUpdateUser = userUtil.calculateUpdateUser(givenPrincipalName, givenAppId);

        // then
        assertEquals(expectedUpdateUser, givenUpdateUser);
    }

    @Test
    void shouldReturnTrimmedValueWhenUserNameTooLong() {

        // given
        String givenPrincipalName = "uid=1013653634853$1";
        String givenAppId = "sampleAppId";
        String expectedUpdateUser = "1013653634853$1_samp";

        // when
        final String givenUpdateUser = userUtil.calculateUpdateUser(givenPrincipalName, givenAppId);

        // then
        assertEquals(expectedUpdateUser, givenUpdateUser);
    }
}