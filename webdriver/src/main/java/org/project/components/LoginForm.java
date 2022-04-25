package org.project.components;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.project.AbstractPage;

public class LoginForm extends AbstractPage {

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public LoginForm fillAndSendLoginForm(String email, String password)  {
        inputForm(LoginPageItem.EMAIL_TEXT_FIELD, email);
        inputForm(LoginPageItem.PASSWORD_TEXT_FIELD, password);
        clickButton(LoginPageItem.SUBMIT_BUTTON);
        return this;
    }

    public void clickButton(LoginPageItem button) {
        driver.findElement(button.getLocator()).click();
    }

    public void jsClickButton(WebDriver driver, LoginPageItem item) {
        WebElement element = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(item.getLocator()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void sendKey(LoginPageItem item, Keys string) {
        driver.findElement(item.getLocator()).sendKeys(string);
    }

    public void inputForm(LoginPageItem inputForm, String inputValue) {
        driver.findElement(inputForm.getLocator()).sendKeys(inputValue);
    }

    public boolean isButtonDisplayed(LoginPageItem button) {
        return driver.findElement(button.getLocator()).isDisplayed();
    }

    public String getItemText(LoginPageItem item) {
        return driver.findElement(item.getLocator()).getText();
    }

    public boolean verifyElementAbsent(LoginPageItem button) throws Exception {
        try {
            driver.findElement(button.getLocator()).isDisplayed();
            System.out.println("Element Present");
            return false;
        } catch (NoSuchElementException e) {
            System.out.println("Element absent");
            return true;
        }
    }
}