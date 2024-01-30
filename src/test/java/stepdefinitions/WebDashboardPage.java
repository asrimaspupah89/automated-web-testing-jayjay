package stepdefinitions;

import helper.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;

public class WebDashboardPage {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    public WebDashboardPage() {
        this.loginPage = new LoginPage();
        this.dashboardPage = new DashboardPage();
    }

    @Given("a user has been logged in")
    public void giverUserIsLogIn() throws InterruptedException{
        System.out.println("user has been login step");
        // open Swag lab Page
        Utility.openPage("https://www.saucedemo.com/"); // navigate to url website
        Thread.sleep(2000);

        loginPage.fillUsername("standard_user"); // input user name
        Thread.sleep(1000);

        loginPage.fillPassword("secret_sauce"); // input password
        Thread.sleep(1000);

        loginPage.buttonLoginClicked(); // click login button
        Thread.sleep(1000);
    }

    @When("user add item to cart")
    public void addItemToCart() throws InterruptedException{
        System.out.println("user add item to cart step");
        dashboardPage.addItemToCart();
        Thread.sleep(1000);
    }

    @When("user remove item from cart")
    public void removeItemFromCart(){
        System.out.println("user remove item from cart step");
        dashboardPage.removeItemFromCart();
    }

    @Then("verify number of cart item is match with {string}")
    public  void verifyNumberOfItemCart(String numberCart) throws InterruptedException{
        System.out.println("verify number of cart item is match with step");
        dashboardPage.verifyNumberOfItemCartDisplayed(numberCart);
        Thread.sleep(1000);
    }
}
