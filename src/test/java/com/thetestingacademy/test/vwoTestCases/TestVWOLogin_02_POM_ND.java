package com.thetestingacademy.test.vwoTestCases;

import com.thetestingacademy.pages.pageObjectModel.vwo.Normal.DashBoardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.Normal.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_02_POM_ND {

    @Owner("PRAMOD")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() {
        WebDriver driver = new EdgeDriver();

        try {
            LoginPage loginPage_vwo = new LoginPage(driver);
            String error_msg = loginPage_vwo.loginToVWOLoginValidCreds("admin@gmail.com", "123");

            // Validate error message
            Assert.assertNotNull(error_msg);
            Assert.assertFalse(error_msg.isBlank(), "Error message should not be blank");
            Assert.assertEquals(error_msg.trim(), "Your email, password, IP address or location did not match");

        } finally {
            driver.quit(); // Close the browser in all cases
        }
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