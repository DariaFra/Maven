package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectedProduct extends BaseView {
    public SelectedProduct(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "wishlist_button")
    private WebElement wishListButton;

    public SuccessBlock addToWishList() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(wishListButton));

        wishListButton.click();
        return new SuccessBlock(driver);

    }
}
