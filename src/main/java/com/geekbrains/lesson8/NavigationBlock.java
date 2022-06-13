package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class NavigationBlock {

    private SelenideElement womenButton = $(By.xpath("//a[@title='Women']"));

    private SelenideElement blousesButtonInWomenTops = $(By.xpath("//a[@title='Blouses']"));


    @Step("Открытие выподающего меню WOMEN")
    public BlousesPage clickToButtonInWomen() {
        womenButton.hover();
        blousesButtonInWomenTops.click();
        return page (BlousesPage.class);
    }
}
