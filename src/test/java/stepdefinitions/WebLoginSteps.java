package stepdefinitions;

import helper.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;

public class WebLoginSteps {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    public WebLoginSteps() {
        this.loginPage = new LoginPage();
        this.dashboardPage = new DashboardPage();
    }

    @Given("user go to Swag Lab page {string}")
    public void navigateToWebApp(String url) throws InterruptedException {
        Utility.openPage(url); // navigate to url website
        Thread.sleep(2000);
    }

    @When("user input username {string}")
    public void entryUsernameField(String username) throws InterruptedException {
        System.out.println("input user name");
        loginPage.fillUsername(username);
        Thread.sleep(1000);
    }

    @And("user input password {string}")
    public void entryPasswordField(String password) throws InterruptedException {
        System.out.println("input password");
        loginPage.fillPassword(password);
        Thread.sleep(1000);
    }

    @And("user click button login")
    public void clickButtonLogin() throws InterruptedException {
        System.out.println("click button login");
        loginPage.buttonLoginClicked();
        Thread.sleep(1000);
    }

    @Then("User should be able to login successfully and new page open")
    public void loginSuccessfully() throws InterruptedException {
        System.out.println("open dashboard");
        dashboardPage.verifyLoginSuccessfull();
        Thread.sleep(1000);
    }

    @Then("User should be able able to see a error message {string} in Login Page")
    public void verifyErrorMessageLoginFailed(String errorMessage){
        loginPage.verifyErrorMessageLoginFailed(errorMessage);
    }
}
