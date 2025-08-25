package org.browserstack.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void successfulLoginTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.manage().window().maximize();

            driver.findElement(By.cssSelector("#username")).sendKeys("student");
            driver.findElement(By.cssSelector("#password")).sendKeys("Password123");
            driver.findElement(By.cssSelector("#submit")).click();

            assert driver.getCurrentUrl().equals("https://practicetestautomation.com/logged-in-successfully/");

            driver.quit();
        } catch (Exception e) {
            driver.quit();
            System.out.println("There was an error: " + e);
        }
    }

    @Test
    public void failedLoginTestUsername() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.manage().window().maximize();

            driver.findElement(By.cssSelector("#username")).sendKeys("wrongStudent");
            driver.findElement(By.cssSelector("#password")).sendKeys("Password123");
            driver.findElement(By.cssSelector("#submit")).click();

            Thread.sleep(3000);

            assert driver.findElement(By.cssSelector("#error")).getText().equals("Your username is invalid!");

            driver.quit();
        } catch (Exception e) {
            driver.quit();
            System.out.println("There was an error: " + e);
        }
    }

    @Test
    public void failedLoginTestPassword() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.manage().window().maximize();

            driver.findElement(By.cssSelector("#username")).sendKeys("student");
            driver.findElement(By.cssSelector("#password")).sendKeys("Password456");
            driver.findElement(By.cssSelector("#submit")).click();

            Thread.sleep(3000);

            assert driver.findElement(By.cssSelector("#error")).getText().equals("Your password is invalid!");

            driver.quit();
        } catch (Exception e) {
            driver.quit();
            System.out.println("There was an error: " + e);
        }
    }
}