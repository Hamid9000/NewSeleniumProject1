package com.thetestingacademy.pages.pageObjectModel.vwo.Improved_pom;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonToAllPage {

    private WebDriver driver;

    // ✅ Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    // ✅ Actions
    public String loginToVWOLoginValidCreds(String user, String pwd) {
        openVWOURL();  // You should define this method in CommanToAllTest if not already
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(signButton);
        presenceOfElement(error_message); // wait for error message to appear
        custom_wait(); // if this is a defined wait method
        return getText(error_message);
    }
}
