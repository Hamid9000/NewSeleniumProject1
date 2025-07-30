package com.Thetestingaccademy;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {
    @Description("sample TC1")
    @Test
    public void testSample0(){
        Assert.assertTrue(true);
    }
    @Description("Sample TC 2")
    @Test
    public void testSample(){
        Assert.assertTrue(true);
    }

}
