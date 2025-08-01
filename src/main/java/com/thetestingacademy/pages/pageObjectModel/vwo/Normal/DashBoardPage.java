package com.thetestingacademy.pages.pageObjectModel.vwo.Normal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
    WebDriver driver;
  public DashBoardPage(WebDriver driver){
      this.driver=driver;
  }

  By userNameOnDashboard =By.cssSelector("[class='page-heading Fw(medium) Mend(4px) Mend(0):lc']");
  public String loggedInUserName(){
      try {
          Thread.sleep(10000);
      }catch (InterruptedException e){
          throw new RuntimeException(e);
      }
      return driver.findElement(userNameOnDashboard).getText();
  }
}
