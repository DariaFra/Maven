package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBlock extends BaseView {
    public NavigationBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womenButton;
    @FindBy(xpath = "//a[@title='Tops']")
    private WebElement topsButtonInWomen;
    @FindBy(xpath = "//ul[contains(@class,'submenu-container')]//a[@title='T-shirts']")
    private WebElement tShirtsButtonInWomenTops;
    @FindBy(xpath = "//a[@title='Blouses']")
    private WebElement blousesButtonInWomenTops;
    @FindBy(xpath = "//ul[contains(@class,'submenu-container')]//a[@title='Dresses']")
    private WebElement dresssesButtonInWomen;

    public NavigationBlock moveToWomenButton() {
        actions.moveToElement(womenButton).build().perform();
        return this;
    }

    public BlousesPage clickToButtonInWomen() {
        blousesButtonInWomenTops.click();
        return new BlousesPage(driver);
    }
}
