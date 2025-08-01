//package com.thetestingacademy.vwoTestCases;
//
//import com.thetestingacademy.pages.pageObjectModel.vwo.Normal.DashBoardPage;
//import com.thetestingacademy.pages.pageObjectModel.vwo.Normal.LoginPage;
//import com.thetestingacademy.utils.PropertiesReader;
//import io.qameta.allure.Description;
//import io.qameta.allure.Owner;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class TestVWOLogin_04_POM_PropertiesReader {
//
//    @Owner("PRAMOD")
//    @Description("Verify that invalid creds give error message")
//    @Test
//    public void testLoginNegativeVWO() {
//        WebDriver driver =new EdgeDriver();
//
//        LoginPage loginPage_VWO =new LoginPage(driver);
//        String error_msg = loginPage_VWO.loginToVWOLoginValidCreds
//                (PropertiesReader.readKey(invalid_username),
//                        PropertiesReader.readKey(invalidapssword));
//
//
//        assertThat(error_msg).isNotEmpty().isNotNull().isNotBlank();
//        Assert.assertEquals(error_msg,PropertiesReader.readKey(error_message));
//    }
//
//}