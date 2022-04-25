package org.project.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.project.configuration.TestData;
import org.project.factory.WebDriverFactory;
import org.project.pageobjects.LoginPage;

public abstract class AbstractTest {

    protected final WebDriver driver = WebDriverFactory.getWebDriver();
    protected final TestData testData = new TestData();
    protected final LoginPage loginPage = new LoginPage(driver);

    @BeforeEach
    public void openHomePage() {
        navigateToThePage(getBaseUrl());
    }

    @AfterEach
    public void tearDown() {
        WebDriverFactory.quitWebDriver();
    }

    protected void navigateToThePage(String url) {
        driver.get(url);
    }

    protected String getBaseUrl() {
        return testData.getEnvironmentData().getUrl();
    }
}