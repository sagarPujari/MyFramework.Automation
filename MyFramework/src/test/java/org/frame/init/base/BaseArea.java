package org.frame.init.base;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.frame.init.runner.runningScript;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BaseArea extends runningScript {
	
	

	public static void scrtiptEntrance( ) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		
		driver.get("https://www.imdb.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		// selecting India as dynamic Drop Down
		TakesScreenshot scrn = ((TakesScreenshot) driver);
		File scFile = scrn.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scFile, new File("C:\\Aniket\\study\\Automation Testing\\helptext.jpeg"));
		driver.findElement(By.xpath("//div[@class='react-autosuggest__container']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='suggestion-search']")).sendKeys("Pushpa: The Rise");;
		
		 // WebElement ele =
		  //driver.findElement(By.xpath("//input[@id='suggestion-search']"));
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  //js.executeScript("arguments[0].value='Pushpa: The Rise';", ele);
		 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='suggestion-search-button']")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Pushpa: The Rise')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Pushpa: The Rise')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Pushpa: The Rise - Part 1']")));
		
		WebElement element = driver.findElement(By.xpath("//h3[text()='Details']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
		scFile = scrn.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scFile, new File("C:\\Aniket\\study\\Automation Testing\\Details_IMDB.jpeg"));
		//driver.findElement(By.xpath("//a[contains(text(),'Pushpa: The Rise')]")).click();
		
		String releaseDate_IMDB = driver.findElement(By.xpath("(//a[text()='Release date']//following::div/ul/li/a)[1]")).getText();
		System.out.println(releaseDate_IMDB);
		
		String country_IMDB= driver.findElement(By.xpath("(//span[text()='Country of origin']//following::div/ul/li/a)[1]")).getText();
		System.out.println(country_IMDB);		
		
		driver.get("https://en.wikipedia.org/");
		scFile = scrn.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scFile, new File("C:\\Aniket\\study\\Automation Testing\\Wiki1.jpeg"));
		driver.findElement(By.xpath("//div[@id='simpleSearch']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='vector-search-box-input']")).sendKeys("Pushpa: The Rise");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='searchButton']")).click();
		element = driver.findElement(By.xpath("(//div[text()='Release date']//following::td/div/ul/li)[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		String ReleaseDate_Wiki = element.getText().trim();
		System.out.println(ReleaseDate_Wiki);
		String country_wiki = driver.findElement(By.xpath("//th[text()='Country']//following-sibling::td")).getText();
		System.out.println(country_wiki);
		Assert.assertEquals(country_IMDB.equalsIgnoreCase(country_wiki), true);
		driver.quit();
		
		//December 17, 2021 (India)
		String releaseDate_IMDB1=releaseDate_IMDB.replace("(India)", "").trim();
		releaseDate_IMDB=releaseDate_IMDB1.replace(",", "");
		System.out.println(releaseDate_IMDB);
		String relase [] =releaseDate_IMDB.split(" ");
		Arrays.sort(relase);
		System.out.println(Arrays.toString(relase));
		String relase_W [] =ReleaseDate_Wiki.split(" ");
		Arrays.sort(relase_W);
		System.out.println(Arrays.toString(relase_W));
		Assert.assertEquals(Arrays.toString(relase_W).equalsIgnoreCase(Arrays.toString(relase)), true);
	
	
	}

}
