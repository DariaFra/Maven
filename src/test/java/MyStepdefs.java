import com.codeborne.selenide.Selenide;
import com.geekbrains.lesson8.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.nio.file.OpenOption;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("User is logged in")
    public void userIsLoggedIn() {
        open("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        new LoginPage().login("frank.d4ri@yandex.ru", "L1234567z");
    }

    @When("Click to button in women")
    public void clickToButtonInWomen() {
        new MyAccountPage().navigationBlock.clickToButtonInWomen();
    }

    @And("Select size S")
    public void selectSizeS() {
        new BlousesPage().selectSize("S");
    }

    @And("choose blouse")
    public void chooseBlouse() {
        new BlousesPage().chooseBlouse();
    }

    @And("Add to wishList")
    public void addToWishList() {
        new SelectedProduct().addToWishList();
    }

    @Then("blouse added to wishList")
    public void blouseAddedToWishList() {
        new SuccessBlock().checkAddToWishList();
    }

    @And("Select size {string}")
    public void selectSizeSize(String size) {
        new BlousesPage().selectSize(size);
    }

    @After(value = "@close")
    public void quitBrauser(){
        Selenide.closeWebDriver();
    }
}
