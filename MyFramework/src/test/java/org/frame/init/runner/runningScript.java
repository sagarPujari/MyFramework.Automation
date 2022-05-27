package org.frame.init.runner;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.frame.init.web.WebdriverInit;

import org.frame.init.base.BaseArea;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.frame.init.web.WebdriverInit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class runningScript extends WebdriverInit {
	
	@BeforeTest

	public void openChromeInit() {
		setupChoromeDr();
	}
	
	
	@Test
    public void basedrive() throws InterruptedException, IOException  {
        
		BaseArea.scrtiptEntrance();
    }
	
	@AfterTest
	
	public void quitDriver() {
		driver.quit();
		
		
    }
	
	
	
}
