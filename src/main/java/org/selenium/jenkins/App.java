package org.selenium.jenkins;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverException;
//import org.openqa.selenium.WebElement;
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
        driver.get("http://18.208.249.169:8081/contact.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.findElement(By.id("inputName")).sendKeys("Paul Mosai");;
        driver.findElement(By.id("inputNumber")).sendKeys("1210222024");;
        driver.findElement(By.id("inputMail")).sendKeys("Paul.Mosai@pysalms.com");;
        driver.findElement(By.id("inputMessage")).sendKeys("Capstone Project DevOps");;
        driver.findElement(By.id("my-button")).click();
    	//capture screenshot
        System.out.println("Selenium Capstone Integration!");
        TakesScreenshot capture =  ((TakesScreenshot)driver);
        File srcFile = capture.getScreenshotAs(OutputType.FILE);
        File desFile = new File("capstone-test-report.jpg");
        try {
			FileHandler.copy(srcFile, desFile);
			System.out.println("screenshot captured and scripts executed. ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.quit();
        
    	}
    
}


    

