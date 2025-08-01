package com.thetestingacademy.test.vwoTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestVWOLogin_01_NormalScript {

    @Description("Verify that with invalid email and password, an error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {

        // Setup Edge browser options
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        // Launch browser
        WebDriver driver = new EdgeDriver(edgeOptions);

        // Open VWO login page
        driver.get("https://app.vwo.com");

        // Enter email
        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        // Enter password
        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("admin");

        // Click login button
        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        // Wait and verify error message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("notification-box-description"))
        );

        // Assertion with message
        Assert.assertEquals(
                errorMessage.getText(),
                "Your email, password, IP address or location did not match",
                "❌ Error message is not as expected!"
        );

        // Close browser
        driver.quit();
    }
}
