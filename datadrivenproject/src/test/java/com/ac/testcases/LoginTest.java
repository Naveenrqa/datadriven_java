package com.ac.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.ac.base.Testbase;


public class LoginTest extends Testbase
{

	@Test
     public void  loginasCA()
     {
    	 driver.findElement(By.xpath(OR.getProperty("homelogin"))).click();
    	 driver.findElement(By.xpath(OR.getProperty("Enter_username"))).sendKeys("abc@gmail.com");
    	 driver.findElement(By.xpath(OR.getProperty("Enter_password"))).sendKeys("3456");
    	 driver.findElement(By.xpath(OR.getProperty("Login"))).click();
     }
}
