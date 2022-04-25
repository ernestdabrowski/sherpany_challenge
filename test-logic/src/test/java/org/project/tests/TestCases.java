package org.project.tests;

import org.junit.jupiter.api.Test;
import org.project.model.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.project.components.LoginPageItem.*;

public class TestCases extends AbstractTest {

    private final User user = testData.getUsersData().get(0);

    @Test
    public void verifyLoginFormSherpanyLoginPage() throws Exception {
        // when
        loginPage.sherpanyLoginPageComponents().isButtonDisplayed(SHERPANY_LOGO);
        loginPage.sherpanyLoginPageComponents().fillAndSendLoginForm(user.getEmail(), user.getPassword());
        loginPage.sherpanyLoginPageComponents().clickButton(SSO_LOGIN_BUTTON);
        // then
        assertTrue(loginPage.sherpanyLoginPageComponents().isButtonDisplayed(EMAIL_TEXT_FIELD));
        assertEquals("Log in with SSO", loginPage.sherpanyLoginPageComponents().getItemText(SSO_LOGIN_BUTTON));
        loginPage.sherpanyLoginPageComponents().verifyElementAbsent(FORGOT_PASSWORD);
    }

    @Test
    public void verfiyFooterLinks() {
        //when
        loginPage.sherpanyLoginPageComponents().isButtonDisplayed(SHERPANY_LOGO);
        //then
        assertEquals("Sherpany.com", loginPage.sherpanyLoginPageComponents().getItemText(FOOTER_SHERPANY_LINK));
        assertEquals("Meeting resources", loginPage.sherpanyLoginPageComponents().getItemText(FOOTER_MEETING_MANAGEMENT_LINK));
        assertEquals("Privacy Policy", loginPage.sherpanyLoginPageComponents().getItemText(FOOTER_PRIVACY_POLICY));
        assertEquals("Terms of Use", loginPage.sherpanyLoginPageComponents().getItemText(FOOTER_TERMS_OF_USE));
    }

    @Test
    public void verifyLanguageSelectorSherpanyLoginPage() {
        loginPage.sherpanyLoginPageComponents().isButtonDisplayed(SHERPANY_LOGO);
        loginPage.sherpanyLoginPageComponents().clickButton(LANGUAGE_DROPDOWN);

        loginPage.sherpanyLoginPageComponents().jsClickButton(driver, DEUTSCH_SELECT);
        assertEquals("Brauchen Sie Hilfe?", loginPage.sherpanyLoginPageComponents().getItemText(TRANSLATION_CHECK_DEUTSCH));
        assertEquals("Anmelden", loginPage.sherpanyLoginPageComponents().getItemText(LOGIN_CONTENT_BOX_TITLE));

        loginPage.sherpanyLoginPageComponents().clickButton(LANGUAGE_DROPDOWN);
        loginPage.sherpanyLoginPageComponents().jsClickButton(driver, ITALIAN_SELECT);
        assertEquals("Ottenere aiuto", loginPage.sherpanyLoginPageComponents().getItemText(TRANSLATION_CHECK_ITALIAN));
        assertEquals("Accedere", loginPage.sherpanyLoginPageComponents().getItemText(LOGIN_CONTENT_BOX_TITLE));

        loginPage.sherpanyLoginPageComponents().clickButton(LANGUAGE_DROPDOWN);
        loginPage.sherpanyLoginPageComponents().jsClickButton(driver, ENGLISH_SELECT);
        assertEquals("Get help", loginPage.sherpanyLoginPageComponents().getItemText(TRANSLATION_CHECK_ENGLISH));
        assertEquals("Log in", loginPage.sherpanyLoginPageComponents().getItemText(LOGIN_CONTENT_BOX_TITLE));

        loginPage.sherpanyLoginPageComponents().clickButton(LANGUAGE_DROPDOWN);
        loginPage.sherpanyLoginPageComponents().jsClickButton(driver, FRENCH_SELECT);
        assertEquals("Mot de passe oublié?", loginPage.sherpanyLoginPageComponents().getItemText(TRANSLATION_CHECK_FRENCH));
        assertEquals("S\'identifier", loginPage.sherpanyLoginPageComponents().getItemText(LOGIN_CONTENT_BOX_TITLE));
    }
}