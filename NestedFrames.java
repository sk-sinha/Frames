package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class NestedFrames {
    ChromeDriver driver;
    public NestedFrames()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void nested_frames() throws InterruptedException
    {
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.switchTo().frame("frame-bottom");
        WebElement bottomFrame = driver.findElement(By.tagName("body"));
        System.out.println(bottomFrame.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement leftFrame = driver.findElement(By.tagName("body"));
        System.out.println(leftFrame.getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        WebElement middleFrame = driver.findElement(By.id("content"));
        System.out.println(middleFrame.getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");
        WebElement rightFrame = driver.findElement(By.tagName("body"));
        System.out.println(rightFrame.getText());

        driver.switchTo().parentFrame();
        driver.close();

    }
   
    public void endTest()  {
        
    }


}