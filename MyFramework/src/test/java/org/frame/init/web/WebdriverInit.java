package org.frame.init.web;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebdriverInit {

	public static WebDriver driver;
	
	public static void setupChoromeDr(){
		DesiredCapabilities cap = new DesiredCapabilities();
		// Init Chrome Options
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("incognito");
		Map<String, Object> prefs = new HashMap<String, Object>();
		Map<String, Object> profile = new HashMap<String, Object>();
		Map<String, Object> contentSettings = new HashMap<String, Object>();
		// SET CHROME OPTIONS
		// 0 - Default, 1 - Allow, 2 - Block
		contentSettings.put("geolocation", 1);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);
		opt.setExperimentalOption("prefs", prefs);

		cap.setCapability(ChromeOptions.CAPABILITY, opt);

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aniket Shinde\\eclipse-workspace\\MyFramework\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver(cap);
		
	
	}

	
	
}
