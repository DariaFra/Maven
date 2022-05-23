package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BlousesPage extends BaseView {
    public BlousesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@id='ul_layered_id_attribute_group_1']//a")
    public List<WebElement> sizesList;

    public BlousesPage selectSize(String size) {
        sizesList.stream().filter(s -> s.getText().contains(size)).findFirst().get().click();
        return this;
    }

    @FindBy(xpath = "//h5//a[@title='Blouse']")
    private WebElement blouseCard;


    public SelectedProduct chooseBlouse() {
        blouseCard.click();
        return new SelectedProduct(driver);

    }

}
