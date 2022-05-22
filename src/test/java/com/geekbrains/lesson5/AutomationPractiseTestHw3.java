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

public class AutomationPractiseTestHw3 {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void inidDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("http://automationpractice.com/index.php?id_category=3&controller=category#/");
    }

    @Test
    void Tops_Add_DelTest() {

        driver.findElement(By.id("uniform-layered_category_4")).click();
        driver.findElement(By.id("uniform-layered_id_attribute_group_1")).click();
        driver.findElement(By.id("layered_id_attribute_group_8")).click();

        driver.findElement(By.xpath("//div[@class='right-block']")).getLocation();

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//div[@class='right-block']")))
                .build()
                .perform();

        driver.findElement(By.xpath("//a[@class='button ajax_add_to_cart_button btn btn-default']")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-default button button-medium']")));
        driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']")).click();

        driver.findElement(By.xpath("//i[@class='icon-trash']")).click();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
