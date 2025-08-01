package com.thetestingacademy.test.vwoTestCases;

import com.thetestingacademy.pages.pageObjectModel.vwo.Normal.DashBoardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.Normal.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_PropertyReader_03 {

    @Owner("PRAMOD")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() throws Exception{
        EdgeOptions edgeOptions =new EdgeOptions();
        edgeOptions.addArguments("--strat-maximized");


        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get(PropertiesReader.readKey("url"));

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys(PropertiesReader.readKey("invalid_username"));

        WebElement passwordinputBoX = driver.findElement(By.name("password"));
        passwordinputBoX.sendKeys(PropertiesReader.readKey("invalid_username"));

        WebElement buttonSubmit=driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        Thread.sleep(6000);


        WebElement error_message =driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(error_message.getText(),PropertiesReader.readKey("error_message"));

        Thread.sleep(6000);
        driver.quit();




    }



    @Owner("PRAMOD")
    @Description("Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginpositiveVWO() {
        WebDriver driver = new EdgeDriver();

        LoginPage loginPage_vwo = new LoginPage(driver);
        loginPage_vwo.loginToVWOLoginValidCreds("leyeca4193@coursora.com", "Rahul12345@");
        DashBoardPage dashBoradPage = new DashBoardPage(driver);
        String usernameLoggedIn = dashBoradPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn, "Set Up Your Account");
    }
}