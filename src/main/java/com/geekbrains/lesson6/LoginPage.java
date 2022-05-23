package com.geekbrains.lesson6;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginPage extends BaseView {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "email")
    public WebElement emailField;
    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordField;
    @FindBy(xpath = "//i[@class='icon-lock left']")
    public WebElement submitLogInButton;



    public MyAccountPage login(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitLogInButton.click();
        return new MyAccountPage(driver);
    }
}
