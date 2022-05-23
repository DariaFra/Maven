package com.geekbrains.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationTest {
    WebDriver driver;
    BlousesPage blousesPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        blousesPage = new BlousesPage(driver);

    }

    @Test
    void addToWishList() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        new LoginPage(driver)
                .login("frank.d4ri@yandex.ru", "L1234567z")
                .navigationBlock.moveToWomenButton()
                .clickToButtonInWomen()
                .selectSize("S")
                .chooseBlouse()
                .addToWishList()
                .checkAddToWishList();
        Assertions.assertTrue(new SuccessBlock(driver).successAdded.isDisplayed());
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
