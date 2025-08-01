package com.thetestingacademy.pages.pageObjectModel.vwo.Normal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 1. Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    // 2. Page Action
    public String loginToVWOLoginValidCreds(String user, String pwd) {
        driver.get("https://app.vwo.com/#/login");
        driver.findElement(username).sendKeys(user);     // ✅ use parameter
        driver.findElement(password).sendKeys(pwd);      // ✅ use parameter
        driver.findElement(signButton).click();

        try {
            Thread.sleep(3000); // Prefer WebDriverWait in real projects
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String error_message_text = driver.findElement(error_message).getText();  // ✅ name match
        return error_message_text;
    }
}
