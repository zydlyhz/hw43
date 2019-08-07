package core;

import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.*;

public class Safari {
	
	static Properties p = new Properties();
	
	
	public static void main(String[] args) throws Exception {
		p.load(new FileInputStream("./input.properties"));
		Logger.getLogger("").setLevel(Level.OFF);
		
		WebDriver driver;
		driver = new SafariDriver();
		driver.manage().window().maximize();
	
		System.out.println("Browser: Safari");
		System.out.println("===========================================================");
		
		
		
		driver.get(p.getProperty("url"));
		System.out.println("Page URI: " + driver.getCurrentUrl());
		System.out.println("Page Title: " + driver.getTitle());
	
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("fname_id")))).sendKeys(p.getProperty("fname_value"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("lname_id")))).sendKeys(p.getProperty("lname_value"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("email_id")))).sendKeys(p.getProperty("email_value"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("phone_id")))).sendKeys(p.getProperty("phone_value"));
		
		
		System.out.println("===================================================================");
		System.out.println("Page URI: " + driver.getCurrentUrl());
		System.out.println("Page Title: " + driver.getTitle());
		System.out.println("First Name: " + driver.findElement(By.id(p.getProperty("fname_id"))).getText());
		System.out.println("Last Name: " + driver.findElement(By.id(p.getProperty("lname_id"))).getText());
		System.out.println("Email: " + driver.findElement(By.id(p.getProperty("email_id"))).getText());
		System.out.println("Phone: " + driver.findElement(By.id(p.getProperty("phone_id"))).getText());
		
		 driver.quit();
	}
	
	

}
