package com.thetestingacademy.test.vwoTestCases;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageObjectModel.vwo.Normal.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_05_POM_PropertiesReader_DriverManager extends CommonToAllPage {

    @Owner("PRAMOD")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() {

        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());

        String error_msg = loginPage_VWO.loginToVWOLoginValidCreds(
                PropertiesReader.readKey("invalid_username"),
                PropertiesReader.readKey("invalid_password")
        );

        // Assertion using AssertJ
        assertThat(error_msg).isNotEmpty().isNotNull().isNotBlank();

        // Assertion using TestNG
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"),
                "Mismatch in expected and actual error message");
    }
}
