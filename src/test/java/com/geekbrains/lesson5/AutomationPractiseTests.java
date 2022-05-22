package com.geekbrains.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AutomationPractiseTests {
    static WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    void loginTest() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        driver.findElement(By.id("email")).sendKeys("frank.d4ri@yandex.ru");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("L1234567z");
        driver.findElement(By.xpath("//i[@class='icon-lock left']")).click();

        webDriverWait.until(ExpectedConditions.urlContains("controller=my-account"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=my-account"));

    }

    @Test
    void addFavorites() {
        driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//h5//a[@title='Blouse']"))).build()
                .perform();
        driver.findElement(By.xpath("//h5//a[@title='Blouse']")).click();
        driver.findElement(By.id("wishlist_button")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='fancybox-error']")));
        Assertions.assertEquals(driver.findElement(By.xpath("//p[@class='fancybox-error']")).isDisplayed(), true);

    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
