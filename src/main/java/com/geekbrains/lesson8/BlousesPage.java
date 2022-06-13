package com.geekbrains.lesson8;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BlousesPage {


    private ElementsCollection sizesList = $$(By.xpath("//ul[@id='ul_layered_id_attribute_group_1']//a"));

    @Step("Выбор размера")
    public BlousesPage selectSize(String size) {
        sizesList.findBy(text(size)).click();
        return this;
    }

    private SelenideElement blouseCard = $(By.xpath("//h5//a[@title='Blouse']"));

    @Step("Открытие катрочки товара")
    public SelectedProduct chooseBlouse() {
        blouseCard.click();
        return page(SelectedProduct.class);

    }

}
