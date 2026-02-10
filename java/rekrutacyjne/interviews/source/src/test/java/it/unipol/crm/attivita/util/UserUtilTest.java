package it.unipol.crm.attivita.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserUtilTest {

    @Autowired
    UserUtil userUtil;

    @Test
    public void shouldCalculateUpdateUserForValidPrincipalName() {

        // given
        String givenPrincipalName = "uid=101853$1";
        String givenAppId = "sampleAppId";
        String expectedUpdateUser = "101853$1_sampleAppId";

        // when
        final String givenUpdateUser = userUtil.calculateUpdateUser(givenPrincipalName, givenAppId);

        // then
        Assert.assertEquals(expectedUpdateUser, givenUpdateUser);
    }

    @Test
    public void shouldReturnDefaultUserForNullPrincipalName() {

        // given
        String givenPrincipalName = null;
        String givenAppId = "sampleAppId";
        String expectedUpdateUser = "attivita-gestione";

        // when
        final String givenUpdateUser = userUtil.calculateUpdateUser(givenPrincipalName, givenAppId);

        // then
        Assert.assertEquals(expectedUpdateUser, givenUpdateUser);
    }

    @Test
    public void shouldReturnDefaultUserWhenMatcherFailed() {

        // given
        String givenPrincipalName = "bjmo";
        String givenAppId = "sampleAppId";
        String expectedUpdateUser = "attivita-gestione";

        // when
        final String givenUpdateUser = userUtil.calculateUpdateUser(givenPrincipalName, givenAppId);

        // then
        Assert.assertEquals(expectedUpdateUser, givenUpdateUser);
    }

    @Test
    public void shouldReturnTrimmedValueWhenUserNameTooLong() {

        // given
        String givenPrincipalName = "uid=1013653634853$1";
        String givenAppId = "sampleAppId";
        String expectedUpdateUser = "1013653634853$1_samp";

        // when
        final String givenUpdateUser = userUtil.calculateUpdateUser(givenPrincipalName, givenAppId);

        // then
        Assert.assertEquals(expectedUpdateUser, givenUpdateUser);
    }
}