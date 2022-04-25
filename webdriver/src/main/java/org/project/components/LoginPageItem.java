package org.project.components;
import org.openqa.selenium.By;

public enum LoginPageItem {
    SHERPANY_LOGO(By.cssSelector("img[alt='sherpany']")),
    EMAIL_TEXT_FIELD(By.id("email")),
    PASSWORD_TEXT_FIELD(By.id("password")),
    SUBMIT_BUTTON(By.cssSelector("button[type='submit']")),
    FORGOT_PASSWORD(By.className("PrimaryLogin_forgotPasswordAction__VPXKh")),
    SSO_LOGIN_BUTTON(By.xpath("//span[text()='Log in with SSO']")),
    LANGUAGE_DROPDOWN(By.cssSelector(".ant-select-selection-item")),
    DEUTSCH_SELECT(By.cssSelector("div[label='Deutsch']")),
    ITALIAN_SELECT(By.cssSelector("div[label='Italiano']")),
    FRENCH_SELECT(By.cssSelector("div[label='Français']")),
    ENGLISH_SELECT(By.cssSelector("div[label='English']")),
    LOGIN_CONTENT_BOX_TITLE(By.className("ContentBoxTitle_heading__ryO0N")),
    FOOTER_SHERPANY_LINK(By.linkText("Sherpany.com")),
    FOOTER_MEETING_MANAGEMENT_LINK(By.xpath("//a[contains(@href, 'https://www.sherpany.com/resources/meeting-management/')]")),
    FOOTER_PRIVACY_POLICY(By.xpath("//a[contains(@href, 'https://www.sherpany.com/privacy-policy/')]")),
    FOOTER_TERMS_OF_USE(By.xpath("//a[contains(@href, 'https://app.sherpany.com/terms/')]")),

    //Translations
    TRANSLATION_CHECK_DEUTSCH(By.xpath("//span[contains(.,'Brauchen Sie Hilfe?')]")),
    TRANSLATION_CHECK_ITALIAN(By.xpath("//span[contains(.,'Ottenere aiuto')]")),
    TRANSLATION_CHECK_FRENCH(By.xpath("//span[contains(.,'Mot de passe oublié?')]")),
    TRANSLATION_CHECK_ENGLISH(By.xpath("//span[contains(.,'Get help')]"));

    private final By locator;

    LoginPageItem(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }
}