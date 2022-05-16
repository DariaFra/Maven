package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DairyNewEntry {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://diary.ru/user/login");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://diary.ru");
        Cookie cookie = new Cookie("_identity_", "4a19c905f66098ccec1d9316acf513ceb9f7e9aaa9e21d447bd402" +
                "9d1ba246faa%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3567138%2C%22KYysgo" +
                "4SRk8ibNCtHsz3abJU0d0iFB_C%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("writeThisDiary")));

        driver.findElement(By.id("writeThisDiary")).click();
        //Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postTitle")));

        driver.findElement(By.id("postTitle")).sendKeys("День первый");
        Thread.sleep(5000);

        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Погода была прекрасная!");
        driver.switchTo().parentFrame();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='rewrite']")).click();
        Thread.sleep(5000);

        driver.quit();

    }
}
