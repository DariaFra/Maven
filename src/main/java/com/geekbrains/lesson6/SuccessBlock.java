package com.geekbrains.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessBlock extends BaseView {
    public SuccessBlock(WebDriver driver) {
        super(driver);
    }

    public final static String SUCCESS_XPATH_LOCATOR = "//div[@class='fancybox-inner']";
    @FindBy(xpath = SUCCESS_XPATH_LOCATOR)
    public WebElement successAdded;


    public void checkAddToWishList() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUCCESS_XPATH_LOCATOR)));
        Assertions.assertTrue(new SuccessBlock(driver).successAdded.isDisplayed());
    }
}
