package org.project.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.project.AbstractPage;
import org.project.components.LoginForm;

public class LoginPage extends AbstractPage {

    @FindBy(id = "email")
    private WebElement singInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginForm sherpanyLoginPageComponents() {
        return new LoginForm(driver);
    }

}