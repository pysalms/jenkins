package org.selenium.jenkins;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.facebook.com/login.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        WebElement userId = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("pass"));
  //     WebElement submitButton = driver.findElement(By.id("loginbutton"));
        userId.sendKeys("test@selenium.assignment.com");
        password.sendKeys("**Password**");
    	//capture screenshot
        System.out.println("Selenium Jenkins Assignment!");
        TakesScreenshot capture =  ((TakesScreenshot)driver);
        File srcFile = capture.getScreenshotAs(OutputType.FILE);
        File desFile = new File("Selenium-test-report.jpg");
        try {
			FileHandler.copy(srcFile, desFile);
			System.out.println("screenshot captured. ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.quit();
        
    }
    
}
