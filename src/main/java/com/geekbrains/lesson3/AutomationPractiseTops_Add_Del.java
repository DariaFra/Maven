package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AutomationPractiseTops_Add_Del {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationpractice.com/index.php?id_category=3&controller=category#/");


        WebElement topsCheckbox = driver.findElement(By.id("uniform-layered_category_4"));
        topsCheckbox.click();
        driver.findElement(By.id("uniform-layered_id_attribute_group_1")).click();
        driver.findElement(By.id("layered_id_attribute_group_8")).click();

        driver.findElement(By.xpath("//div[@class='right-block']")).getLocation();

        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//div[@class='right-block']"));
        action.moveToElement(we).build().perform();

        driver.findElement(By.xpath("//a[@class='button ajax_add_to_cart_button btn btn-default']")).click();


        driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']")).click();


        driver.findElement(By.xpath("//i[@class='icon-trash']")).click();


        driver.quit();
    }
}
