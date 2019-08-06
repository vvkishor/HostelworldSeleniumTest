package com.techtest.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Question2Test {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\vijaya.kishore\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://www.hostelworld.com");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        WebElement myElement = driver.findElement(By.id("home-search-keywords"));
        Thread.sleep(1000);

        myElement.sendKeys(("Dublin"));
        Actions action = new Actions(driver);
        Thread.sleep(1000);

        WebElement suggestions = driver.findElement(By.cssSelector("strong:nth-child(1)"));
        action.moveToElement(suggestions).perform();
        action.click();
        action.perform();
        Thread.sleep(1000);

        driver.findElement(By.className("btn-block")).click();
        Thread.sleep(1000);

        if(driver.getPageSource().contains("Dublin Hostels"))
            System.out.println("Content on the page as expected - Content verification Test: PASSED ");
        else
            System.out.println("Content on the web page is not as expected - Content verification Test: FAILED");
        Thread.sleep(10000);


        /* driver.close(); */


    }


}

