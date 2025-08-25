package org.browserstack.training;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void simpleSeleniumTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://duckduckgo.com");
        driver.manage().window().maximize();

        WebElement searchBoxElement = driver.findElement(By.cssSelector("#searchbox_input"));
        searchBoxElement.sendKeys("BrowserStack");
        searchBoxElement.sendKeys(Keys.ENTER);

        assert driver.getCurrentUrl().contains("https://duckduckgo.com/?t=h_&q=BrowserStack");

        driver.quit();
    }
}