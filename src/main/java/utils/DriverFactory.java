package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	public static WebDriver driver;

	public static WebDriver iniciaBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver iniciaNavegador() {
		if (driver == null) {
			return iniciaBrowser();
		}
		return driver;
	}

	public void fechaDriver() {
		if (null != driver) {
			driver.quit();
		}
		return driver;
	}
}