package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SelectedProduct {

    private SelenideElement wishListButton = $(By.id("wishlist_button"));

    @Step("Клик на иконку сердечко")
    public SuccessBlock addToWishList() {
        wishListButton.click();
        return page(SuccessBlock.class);

    }
}
