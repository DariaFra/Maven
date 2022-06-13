package com.geekbrains.lesson8;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;

public class SuccessBlock {

    private SelenideElement successAdded = $(By.xpath("//div[@class='fancybox-inner']"));



    public void checkAddToWishList() {
        successAdded.shouldBe(disappear);
    }
}
